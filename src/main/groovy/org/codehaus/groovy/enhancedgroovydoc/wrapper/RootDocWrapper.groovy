package org.codehaus.groovy.enhancedgroovydoc.wrapper


import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;

import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;
import org.codehaus.groovy.groovydoc.GroovyRootDoc 

class RootDocWrapper implements RootDoc {

	
	GroovyRootDoc groovyRootDoc
	String[][] options
	
	public RootDocWrapper(GroovyRootDoc grd){
		this.groovyRootDoc = grd
	}
	
	@Override
	public String commentText() {		
		return this.groovyRootDoc.commentText();
	}

	@Override
	public int compareTo(Object obj) {		
		return this.groovyRootDoc.compareTo(obj);
	}

	@Override
	public Tag[] firstSentenceTags() {
		// TODO Auto-generated method stub
		return new Tag[0];
	}

	@Override
	public String getRawCommentText() {
		return this.groovyRootDoc.getRawCommentText();
	}

	@Override
	public Tag[] inlineTags() {
		// TODO Auto-generated method stub
		return new Tag[0];
	}

	@Override
	public boolean isAnnotationType() {
		return this.groovyRootDoc.isAnnotationType()		
	}

	@Override
	public boolean isAnnotationTypeElement() {
		return this.groovyRootDoc.isAnnotationTypeElement()
	}

	@Override
	public boolean isClass() {
		println "THIS IS CLASS? ${this.groovyRootDoc.getClass()} ${this.groovyRootDoc.isClass()}"
//		return this.groovyRootDoc.isClass();
		return false
	}

	@Override
	public boolean isConstructor() {	
		return this.groovyRootDoc.isConstructor();
	}

	@Override
	public boolean isEnum() {
		return this.groovyRootDoc.isEnum();
	}

	@Override
	public boolean isEnumConstant() {
		return this.groovyRootDoc.isEnumConstant();
	}

	@Override
	public boolean isError() {
		return this.groovyRootDoc.isError()
	}

	@Override
	public boolean isException() {
		return this.groovyRootDoc.isException()
	}

	@Override
	public boolean isField() {
		return this.groovyRootDoc.isField()
	}

	@Override
	public boolean isIncluded() {
		return this.groovyRootDoc.isIncluded()
	}

	@Override
	public boolean isInterface() {
		return this.groovyRootDoc.isInterface()
	}

	@Override
	public boolean isMethod() {
		return this.groovyRootDoc.isMethod()
	}

	@Override
	public boolean isOrdinaryClass() {
		return this.groovyRootDoc.isOrdinaryClass()
	}

	@Override
	public String name() {
		return this.groovyRootDoc.name()?:"null"
	}

	@Override
	public SourcePosition position() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeeTag[] seeTags() {
		// TODO Auto-generated method stub
		return new SeeTag[0]
	}

	@Override
	public void setRawCommentText(String txt) {
		this.groovyRootDoc.setRawCommentText(txt)

	}

	@Override
	public Tag[] tags() {
		// TODO Auto-generated method stub
//		println "Asking for tags "
		return new Tag[0];
	}

	@Override
	public Tag[] tags(String arg0) {
		// TODO Auto-generated method stub
//		println "Asking for tags ${arg0}"
		return new Tag[0];
	}

	@Override
	public void printError(String error) {
		this.groovyRootDoc.printError(error)
	}

	@Override
	public void printError(SourcePosition position, String error) {
		this.groovyRootDoc.printError(position,error)

	}

	@Override
	public void printNotice(String txt) {
		this.groovyRootDoc.printNotice(txt)

	}

	@Override
	public void printNotice(SourcePosition position, String txt) {
		this.groovyRootDoc.printNotice(position,txt)

	}

	@Override
	public void printWarning(String txt) {
		this.groovyRootDoc.printWarning(txt)

	}

	@Override
	public void printWarning(SourcePosition position, String txt) {
		this.groovyRootDoc.printWarning(position,txt)

	}

	@Override
	public ClassDoc classNamed(String name) {
		return this.groovyRootDoc.classNamed(name)
	}

	@Override
	public ClassDoc[] classes() {			
		GroovyClassDoc[] classDocs = this.groovyRootDoc.classes();
//		println "GETTING CLASSES ${classDocs.collect{ it.name() }}"
		ClassDoc[] wrapped = new ClassDoc[classDocs.length]
		classDocs.eachWithIndex { 
			classDoc, idx ->
			wrapped[idx]=new ClassDocWrapper(classDoc)	
		}		 	
		return  wrapped
	}

	@Override
	public String[][] options() {
		String[][] options
		if(this.options!=null){
			options = this.options
		}
		else{		
			if(groovyRootDoc.options){
				options = groovyRootDoc.options
			}
			else{
				options = this.groovyRootDoc.options()?:new String[0][0]
			}
		}
		return options
	}

	public void setOptions(String[][] options){
		this.options = options
	}
	
	
	@Override
	public PackageDoc packageNamed(String pkg) {
		
		return this.groovyRootDoc.packageNamed(pkg);
	}

	@Override
	public ClassDoc[] specifiedClasses() {
//		println "GETTING SPECIFIED CLASSES"
		GroovyClassDoc[] classes = this.groovyRootDoc.specifiedClasses()
		ClassDocWrapper[] wrapper = new ClassDocWrapper[classes?.length?:0]
		classes.eachWithIndex { 
			clazz,idx ->
			wrapper[idx] = new ClassDocWrapper(clazz)	
		}
		return wrapper
	}

	@Override
	public PackageDoc[] specifiedPackages() {
		GroovyPackageDoc[] packages = this.groovyRootDoc.specifiedPackages()
		PackageDoc[] wrapped = new PackageDocWrapper[packages.length]
		packages.eachWithIndex { 
			packaged, idx ->
			wrapped[idx]=new PackageDocWrapper(packaged)	
		}
		return wrapped
	}

}
