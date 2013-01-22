package org.codehaus.groovy.enhancedgroovydoc

import groovyjarjarantlr.RecognitionException
import groovyjarjarantlr.TokenStreamException
import org.codehaus.groovy.groovydoc.GroovyRootDoc
import org.codehaus.groovy.tools.groovydoc.*

class ImprovedGroovyDocTool extends GroovyDocTool {

    private final GroovyRootDocBuilder rootDocBuilder;
    private final GroovyDocTemplateEngine templateEngine;
    private Properties properties;
	private GroovyRootDoc createdRootDoc

	public ImprovedGroovyDocTool(ResourceManager resourceManager, String[] sourcepaths, String[] docTemplates, String[] packageTemplates, String[] classTemplates, List<LinkArgument> links, Properties properties) {
		super(resourceManager, sourcepaths, docTemplates, packageTemplates, classTemplates, links, properties);
		rootDocBuilder = new GroovyRootDocBuilder(this, sourcepaths, links, properties);
		this.properties = properties;
		if (resourceManager == null) {
			templateEngine = null;
		} else {
			templateEngine = new GroovyDocTemplateEngine(this, resourceManager, docTemplates, packageTemplates, classTemplates, properties);
		}
	}
	
    /**
     * Constructor for use by people who only want to interact with the Groovy Doclet Tree (rootDoc)
     *
     * @param sourcepaths where the sources to be added can be found
     */
    public ImprovedGroovyDocTool(String[] sourcepaths) {
        this(null, sourcepaths, null);
    }

    public ImprovedGroovyDocTool(ResourceManager resourceManager, String[] sourcepaths, String classTemplate) {
        this(resourceManager, sourcepaths, new String[0], new String[0], new String[classTemplate], new ArrayList<LinkArgument>(), new Properties());
    }

    

    public void add(List<String> filenames) throws RecognitionException, TokenStreamException, IOException {
        if (templateEngine != null) {
            // only print out if we are being used for template generation
            System.out.println("Loading source files for " + filenames);
        }
        rootDocBuilder.buildTree(filenames);
    }

    public GroovyRootDoc getRootDoc() {
		if(createdRootDoc!=null){
			return createdRootDoc
		}
		else{
			return rootDocBuilder.getRootDoc();
		}
    }

    public void renderToOutput(OutputTool output, String destdir) throws Exception {
        // expect just one scope to be set on the way in but now also set higher levels of visibility
        if ("true".equals(properties.getProperty("privateScope"))) properties.setProperty("packageScope", "true");
        if ("true".equals(properties.getProperty("packageScope"))) properties.setProperty("protectedScope", "true");
        if ("true".equals(properties.getProperty("protectedScope"))) properties.setProperty("publicScope", "true");
        if (templateEngine != null) {
            GroovyDocWriter writer = new GroovyDocWriter(this, output, templateEngine, properties);
            GroovyRootDoc rootDoc = rootDocBuilder.getRootDoc();
			createdRootDoc = rootDoc
            writer.writeRoot(rootDoc, destdir);
            writer.writePackages(rootDoc, destdir);
            writer.writeClasses(rootDoc, destdir);
        } else {
            throw new UnsupportedOperationException("No template engine was found");
        }
    }

    String getPath(String filename) {
        String path = new File(filename).getParent();
        // path length of 1 indicates that probably is 'default package' i.e. "/"
        if (path == null || path.length() == 1) {
            path = "DefaultPackage"; // "DefaultPackage" for 'default package' path, rather than null...
        }
        return path;
    }

    String getFile(String filename) {
        return new File(filename).getName();
    }
}
