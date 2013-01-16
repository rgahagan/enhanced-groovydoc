package org.codehaus.groovy.enhancedgroovydoc.wrapper


import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;

class PackageDocWrapper implements PackageDoc {

	GroovyPackageDoc packageDoc
	
	public PackageDocWrapper(GroovyPackageDoc gpd){
		this.packageDoc=gpd
	}
	
	@Override
	public String commentText() {
		return packageDoc.commentText()
	}

	@Override
	public int compareTo(Object arg0) {
		if(arg0 instanceof PackageDoc){
			return -1
		}
	}

	@Override
	public Tag[] firstSentenceTags() {
		// TODO Auto-generated method stub
		return new Tag[0];
	}

	@Override
	public String getRawCommentText() {
		return packageDoc.getRawCommentText();
	}

	@Override
	public Tag[] inlineTags() {
		// TODO Auto-generated method stub
		return new Tag[0];
	}

	@Override
	public boolean isAnnotationType() {
		return packageDoc.isAnnotationType();
	}

	@Override
	public boolean isAnnotationTypeElement() {
		return packageDoc.isAnnotationTypeElement()
	}

	@Override
	public boolean isClass() {
		//return packageDoc.isClass()
		return false
	}

	@Override
	public boolean isConstructor() {
		return packageDoc.isConstructor()
	}

	@Override
	public boolean isEnum() {
		return packageDoc.isEnum()
	}

	@Override
	public boolean isEnumConstant() {
		return packageDoc.isEnumConstant()
	}

	@Override
	public boolean isError() {
		return packageDoc.isError()
	}

	@Override
	public boolean isException() {
		return packageDoc.isException()
	}

	@Override
	public boolean isField() {
		return packageDoc.isField()
	}

	@Override
	public boolean isIncluded() {
		return packageDoc.isIncluded()
	}

	@Override
	public boolean isInterface() {
		return packageDoc.isInterface()
	}

	@Override
	public boolean isMethod() {
		return packageDoc.isMethod()
	}

	@Override
	public boolean isOrdinaryClass() {
		return packageDoc.isOrdinaryClass()
	}

	@Override
	public String name() {
		return packageDoc.name()?:"null"
	}

	@Override
	public SourcePosition position() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeeTag[] seeTags() {
		// TODO Auto-generated method stub
		return new SeeTag[0];
	}

	@Override
	public void setRawCommentText(String arg0) {
		packageDoc.setRawCommentText(arg0)

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
	public ClassDoc[] allClasses() {
		GroovyClassDoc[] classes = packageDoc.allClasses()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex{
			clazz, idx ->

			wrapped[idx] = new ClassDocWrapper(clazz)
		}
		return wrapped
	}

	@Override
	public ClassDoc[] allClasses(boolean arg0) {
		GroovyClassDoc[] classes = packageDoc.allClasses(arg0)
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex{
			clazz, idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
		}
		return wrapped
	}

	@Override
	public AnnotationTypeDoc[] annotationTypes() {
		// TODO Auto-generated method stub
		return new AnnotationTypeDoc[0]
	}

	@Override
	public AnnotationDesc[] annotations() {
		// TODO Auto-generated method stub
		return new AnnotationDesc[0];
	}

	@Override
	public ClassDoc[] enums() {
		GroovyClassDoc[] classes = packageDoc.enums()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex{
			clazz, idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
		}
		return wrapped
	}

	@Override
	public ClassDoc[] errors() {
		GroovyClassDoc[] classes = packageDoc.errors()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex{
			clazz, idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
		}
		return wrapped
	}

	@Override
	public ClassDoc[] exceptions() {
		GroovyClassDoc[] classes = packageDoc.exceptions()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex{
			clazz, idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
		}
		return wrapped
	}

	@Override
	public ClassDoc findClass(String arg0) {
		
		return packageDoc.findClass(arg0)
	}

	@Override
	public ClassDoc[] interfaces() {
		GroovyClassDoc[] classes = packageDoc.interfaces()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex{
			clazz, idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
		}
		return wrapped
	}

	@Override
	public ClassDoc[] ordinaryClasses() {
		GroovyClassDoc[] classes = packageDoc.ordinaryClasses()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex{
			clazz, idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
		}
		return wrapped
	}

}
