package org.umlgraph.groovydoc;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.types.DirSet;
import org.apache.tools.ant.types.Path 
import org.apache.tools.ant.types.PatternSet;
import org.codehaus.groovy.tools.groovydoc.ClasspathResourceManager 
import org.codehaus.groovy.tools.groovydoc.GroovyDocTool 
import org.codehaus.groovy.tools.groovydoc.GroovyRootDocBuilder;
import org.codehaus.groovy.tools.groovydoc.LinkArgument;
import org.codehaus.groovy.tools.groovydoc.gstringTemplates.GroovyDocTemplateInfo 

import groovy.util.GroovyTestCase;
import groovy.util.AntBuilder;

class TestGroovyDocGeneration extends GroovyTestCase {

	public void testGeneration(){
			
			def ant = new AntBuilder()
			ant.taskdef(name: "groovydoc", classname: "org.codehaus.groovy.enhancedgroovydoc.DocletGroovyDoc")
//			ant.taskdef(name: "groovydoc", classname: "org.codehaus.groovy.ant.Groovydoc")			
			ant.groovydoc(
					destdir: "target/gapi",
					sourcepath:"src/main/groovy",
					packagenames:"**.*",
					use:"true",
					windowtitle:"test",
					doctitle:"test",
					header:"test",
					footer:"test",
					//overview:""src/main/overview.html",
					private:"false",
				{
				   link(packages:"java.,org.xml.,javax.,org.xml.",href:"http://java.sun.com/j2se/1.5.0/docs/api")
				   link(packages:"groovy.,org.codehaus.groovy.", href:"http://groovy.codehaus.org/api")
				   link(packages:"org.apache.ant.,org.apache.tools.ant.", href:"http://www.dpml.net/api/ant/1.7.0")
				   link(packages:"org.junit.,junit.framework.", href:"http://junit.sourceforge.net/junit3.8.1/javadoc/")
				   doclet(name:"org.umlgraph.groovydoc.doclet.GroovyUmlGraphDoc" ){
					   param(name:"-all")
					   param(name:"-attributes")
					   param(name:"-operations")
					   param(name:"-qualify")
					   param(name:"-types")
					   param(name:"-visibility")
					   param(name:"-d",value:"target/gapi")					   
				   }
				   doclet(name:"net.sdedit.taglet.GroovySdEditDoc" )
				   
				}
			)
			
			
			
			
			assertTrue true

	}
		
}
