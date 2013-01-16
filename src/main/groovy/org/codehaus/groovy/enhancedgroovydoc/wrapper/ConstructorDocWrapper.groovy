package org.codehaus.groovy.enhancedgroovydoc.wrapper


import org.codehaus.groovy.groovydoc.GroovyClassDoc 
import org.codehaus.groovy.groovydoc.GroovyType;

import org.codehaus.groovy.groovydoc.GroovyParameter;

import org.codehaus.groovy.groovydoc.GroovyConstructorDoc;



import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import com.sun.javadoc.ThrowsTag;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;

class ConstructorDocWrapper implements ConstructorDoc {

	GroovyConstructorDoc doc
	
	public ConstructorDocWrapper(GroovyConstructorDoc dc){
		this.doc = dc
	}
	
	@Override
	public String flatSignature() {
		return doc.flatSignature()
	}

	@Override
	public boolean isNative() {
		return doc.isNative()
	}

	@Override
	public boolean isSynchronized() {
		return doc.isSynchronized()
	}

	@Override
	public boolean isVarArgs() {
		return doc.isVarArgs()
	}

	@Override
	public ParamTag[] paramTags() {
		// TODO Auto-generated method stub
		return new ParamTag[0]
	}

	@Override
	public Parameter[] parameters() {
		GroovyParameter[] params = doc.parameters()
		Parameter[] wrapped = new ParameterWrapper[params.length]
		params.eachWithIndex{
			par,idx ->
			wrapped[idx] = new ParameterWrapper(par)
		}
		return wrapped
	}

	@Override
	public String signature() {
		return doc.signature()
	}

	@Override
	public Type[] thrownExceptionTypes() {
		GroovyType[] types = doc.thrownExceptionTypes()
		Type[] wrapper = new Type[types.length]
		types.eachWithIndex { 
			typ, idx->
			wrapper[idx] = new TypeWrapper(typ)
		}		
		return wrapper 
	}

	@Override
	public ClassDoc[] thrownExceptions() {
		GroovyClassDoc[] classes = doc.thrownExceptions()
		ClassDocWrapper[] wrapper = new ClassDocWrapper[classes.length]
		classes.eachWithIndex { 
			clazz,idx ->
			wrapper[idx] = new ClassDocWrapper(clazz)
			}
		
		return wrapper
	}

	@Override
	public ThrowsTag[] throwsTags() {	
		return new ThrowsTag[0]
	}

	@Override
	public ParamTag[] typeParamTags() {
		return new ParamTag[0]
	}

	@Override
	public TypeVariable[] typeParameters() {
		// TODO Auto-generated method stub		
		return new TypeVariable[0]
	}

	@Override
	public boolean isSynthetic() {
		return doc.isSynthetic()
	}

	@Override
	public AnnotationDesc[] annotations() {
		return new AnnotationDesc[0]
	}

	@Override
	public ClassDoc containingClass() {
//		return doc.containingClass()!=null?new ClassDocWrapper(doc.containingClass()):null
//		println "GETTING CONTAINING ${doc.name()} - ${doc.containingClass()} - ${doc.containingClass()?.name()} - ${doc.belongsToClass}"
		GroovyClassDoc clazz = doc.containingClass()
		if(clazz == null){
			clazz = doc.belongsToClass
		}
		return clazz!=null?new ClassDocWrapper(clazz):null
	}

	@Override
	public PackageDoc containingPackage() {
		return doc.containingPackage()!=null?new PackageDocWrapper(doc.containingPackage()):null
	}

	@Override
	public boolean isFinal() {
		return doc.isFinal()
	}

	@Override
	public boolean isPackagePrivate() {
		return doc.isPackagePrivate()
	}

	@Override
	public boolean isPrivate() {
		return doc.isPrivate()
	}

	@Override
	public boolean isProtected() {
		return doc.isProtected()
	}

	@Override
	public boolean isPublic() {
		return doc.isPublic()
	}

	@Override
	public boolean isStatic() {
		return doc.isStatic()
	}

	@Override
	public int modifierSpecifier() {
		return doc.modifierSpecifier()
	}

	@Override
	public String modifiers() {
		return doc.modifiers()
	}

	@Override
	public String qualifiedName() {
		return doc.qualifiedName()?:doc.name()
	}

	@Override
	public String commentText() {
		return doc.commentText()
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public Tag[] firstSentenceTags() {
		// TODO Auto-generated method stub
		return new Tag[0]
	}

	@Override
	public String getRawCommentText() {
		return doc.getRawCommentText()
	}

	@Override
	public Tag[] inlineTags() {
		return new Tag[0]
	}

	@Override
	public boolean isAnnotationType() {
		return doc.isAnnotationType()
	}

	@Override
	public boolean isAnnotationTypeElement() {
		return doc.isAnnotationTypeElement()
	}

	@Override
	public boolean isClass() {
		return doc.isClass()
	}

	@Override
	public boolean isConstructor() {
		return doc.isConstructor()
	}

	@Override
	public boolean isEnum() {
		return doc.isEnum()
	}

	@Override
	public boolean isEnumConstant() {
		return doc.isEnumConstant()
	}

	@Override
	public boolean isError() {
		return doc.isError()
	}

	@Override
	public boolean isException() {
		return doc.isException()
	}

	@Override
	public boolean isField() {
		return doc.isField()
	}

	@Override
	public boolean isIncluded() {
		return doc.isIncluded()
	}

	@Override
	public boolean isInterface() {
		return doc.isInterface()
	}

	@Override
	public boolean isMethod() {
		return doc.isMethod()
	}

	@Override
	public boolean isOrdinaryClass() {
		return doc.isOrdinaryClass()
	}

	@Override
	public String name() {
		return doc.name()?:"null"
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
	public void setRawCommentText(String arg0) {
		doc.setRawCommentText(arg0)
	}

	@Override
	public Tag[] tags() {
//		println "Asking for tags "
		return new Tag[0]
	}

	@Override
	public Tag[] tags(String arg0) {
//		println "Asking for tags ${arg0}"
		return new Tag[0]
	}

}
