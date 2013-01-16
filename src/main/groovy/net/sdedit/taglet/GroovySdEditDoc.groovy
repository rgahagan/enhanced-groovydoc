package net.sdedit.taglet


import java.util.regex.Pattern 
import net.sf.sdedit.config.Configuration;
import net.sf.sdedit.config.ConfigurationManager;
import net.sf.sdedit.diagram.Diagram;
import net.sf.sdedit.editor.DiagramLoader;
import net.sf.sdedit.text.TextHandler;
import net.sf.sdedit.ui.ImagePaintDevice;
import net.sf.sdedit.ui.components.configuration.Bean;
import net.sf.sdedit.util.Pair;



import com.sun.javadoc.RootDoc 
import com.sun.tools.doclets.standard.Standard 

import org.codehaus.groovy.enhancedgroovydoc.wrapper.RootDocWrapper;
import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyMethodDoc;
import org.codehaus.groovy.groovydoc.GroovyRootDoc;
import org.umlgraph.doclet.UmlGraph 

class GroovySdEditDoc {

	public static final String STARTING_TEXT = "<DL><DT><B>sequence.diagram:</B></DT><DD>"
	public static final String ENDING_TEXT = "</DD></DL>"
	public static final String TAG = "sequence.diagram"
	
	public static final String DIV_TEXT ="""
		<!-- UML diagram added by SdEdit version 2.1.1 (http://www.sdedit.sf.net/) -->
		<div align="center">
		<img src=\"%1\$s_seq.png\" alt="Sequence diagram package %1\$s\" border="0"/>
		</div>	
	"""
	
	/**
	* Option check, forwards options to the standard doclet, if that one refuses them,
	* they are sent to UmlGraph
	*/
	public static int optionLength(String option) {
		int result = Standard.optionLength(option);
		if (result != 0)
			return result;
		else
			return UmlGraph.optionLength(option);
	}
	
	/**
	* Standard doclet entry point
	* @param root
	* @return
	*/
   public static boolean start(GroovyRootDoc root) {
	   root.printNotice("SdEdit version 2.1.1, running the standard doclet");
	   RootDoc unwrapped = new RootDocWrapper(root)
	   root.printNotice("SdEdit version 2.2.1, altering javadocs");
	   try {
		   String[][] options = unwrapped.options()
		   String outputFolder = findOutputPath(options);
		   
		   def registry = generateSequenceDiagrams(root,outputFolder)
		   
		   alterHtmlDocs(registry)
		   
	   } catch(Throwable t) {
		   root.printWarning("Error!");
		   root.printWarning(t.toString());
		   t.printStackTrace();
		   return false;
	   }
	   return true;
   }
   private static void alterHtmlDocs(Map registry){
	   registry.each{
		   className,list ->
		   def diagramName = list[0]
		   def htmlFile = getHtmlFileName(diagramName)
		   def fileList=new File(htmlFile).readLines()			   
		   setClassDiagram(htmlFile,fileList,className,list)

	   }
   }
   
   private static void setClassDiagram(String filename, def fileList,String className,List elementNames){
	   def classPattern = Pattern.compile(".*(Groovy|Java)\\] (Class|Interface|Enum) " + className + ".*")
	   def methodIdPattern = Pattern.compile("(.*_)(.+)(_seq.png)")
	   def methodNamePattern = ".*%1\$s</H3>"
	   def methodNames = elementNames.collect{ getMethodName(methodIdPattern,it) }
	   def outputLines = []
	   def writer= new FileWriter(filename)
	   fileList.each{
		   line ->
		   def idxRemoval = -1
		   writer.write(line)
		   writer.write("\n")
		   methodNames.eachWithIndex{
			   name,idx ->
			   if(name=="null"&&classPattern.matcher(line).matches()){
				   writer.write(String.format(DIV_TEXT,className))
				   writer.write("\n")
				   idxRemoval=idx
			   }
			   else if(line.matches(String.format(methodNamePattern,name))){
				   writer.write(String.format(DIV_TEXT,"${className}_${name}"))
				   writer.write("\n")
				   idxRemoval=idx
			   }
		   }
		   if(idxRemoval>0){ 
			  methodNames.remove(idxRemoval)
		   }		   
	   }
	   writer.close()
   }
   
   private static String getMethodName(def patternId, String diagramName){
	   def matcher =patternId.matcher(diagramName) 
	   if(!matcher.matches()){
		   return "null"
	   }
	   else{
		   return matcher[0][2]
	   }
	   
   }
   
   private static String getHtmlFileName(String diagramName){
	   def fileName = diagramName.substring(0,diagramName.indexOf("_"))
	   return fileName+".html"
   }
   
   private static Map generateSequenceDiagrams(GroovyRootDoc root, String outputFolder){
	   def registry = [:]
	   for (GroovyClassDoc classDoc : root.classes()) {
		    String packageName = classDoc.containingPackage()?.name()?:""
			if(containsSequenceDiagram(classDoc.commentText())){
				def filename= obtainOutputPath(outputFolder,packageName,classDoc.name(),null)
				String diagram = stripDiagram(classDoc.commentText())				
				createDiagram(diagram,filename)
				if(!registry.containsKey(classDoc.name())){
					registry[classDoc.name()]=[filename]
				}
				else{
					registry[classDoc.name()]<<filename
				}
			}
			classDoc.methods().each { 
				GroovyMethodDoc method ->
				if(containsSequenceDiagram(method.commentText())){
					def filename= obtainOutputPath(outputFolder,packageName,classDoc.name(),method.name())
					String diagram = stripDiagram(method.commentText())
					createDiagram(diagram,filename)
					if(!registry.containsKey(classDoc.name())){
						registry[classDoc.name()]=[filename]
					}
					else{
						registry[classDoc.name()]<<filename
					}
				}
			}	   		
	   }
	   return registry
   }
   
   private static void createDiagram(String diagram,String outputFile){
	   String type = "png";
	   String format = "A4";
	   String orientation = "Portrait";
	   InputStream input = new ByteArrayInputStream(diagram.getBytes())
	   OutputStream output = new FileOutputStream(new File(outputFile))
	   Pair<String, Bean<Configuration>> pair = DiagramLoader.load(input,
		   ConfigurationManager.getGlobalConfiguration().getFileEncoding())
	   TextHandler th = new TextHandler(pair.getFirst());
	   Bean<Configuration> conf = pair.getSecond();
	   ImagePaintDevice paintDevice = new ImagePaintDevice();
	   new Diagram(conf.getDataObject(), th, paintDevice).generate();
	   paintDevice.writeToStream(output);
   }
   
   private static String obtainOutputPath(String outputFolder,String path,String className, String methodName){
	   def fs = System.getProperty("file.separator")
	   String file = "${outputFolder}${fs}${path}${fs}${className}"
	   if(methodName){
		   file+="_${methodName}"
	   }
	   file+="_seq.png"
	   return file
   }
   
   private static boolean containsSequenceDiagram(String text){
   		return text.indexOf(STARTING_TEXT) != -1
   }
   
   private static String stripDiagram(String text){
	   if(text.indexOf(TAG)==-1){
		   return ""
	   }
	   def idx = text.indexOf(STARTING_TEXT) + STARTING_TEXT.length()
	   text = text.substring(idx)
	   idx = text.indexOf(ENDING_TEXT)
	   text = text.substring(0,idx)
	   return text
   }
   
   /**
   * Returns the output path specified on the javadoc options
   */
  private static String findOutputPath(String[][] options) {
	  for (int i = 0; i < options.length; i++) {
		  if (options[i][0].equals('-d')){
			  return options[i][1];
		  }
	  }
	  return ".";
  }
	
}
