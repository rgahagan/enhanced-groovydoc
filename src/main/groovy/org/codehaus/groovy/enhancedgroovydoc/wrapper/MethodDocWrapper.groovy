package org.codehaus.groovy.enhancedgroovydoc.wrapper


import com.sun.javadoc.AnnotationDesc 
import com.sun.javadoc.ClassDoc 
import com.sun.javadoc.MethodDoc 
import com.sun.javadoc.PackageDoc 
import com.sun.javadoc.ParamTag 
import com.sun.javadoc.Parameter 
import com.sun.javadoc.SeeTag 
import com.sun.javadoc.SourcePosition 
import com.sun.javadoc.Tag 
import com.sun.javadoc.ThrowsTag 
import com.sun.javadoc.Type 
import com.sun.javadoc.TypeVariable 

import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyMethodDoc 
import org.codehaus.groovy.groovydoc.GroovyParameter;
import org.codehaus.groovy.groovydoc.GroovyType;

class MethodDocWrapper implements MethodDoc {

	GroovyMethodDoc methodDoc
	
	public MethodDocWrapper(GroovyMethodDoc doc){
		methodDoc=doc
	}
	
	@Override
	public String flatSignature() {
		return methodDoc.flatSignature()
	}

	@Override
	public boolean isNative() {
		return methodDoc.isNative()
	}

	@Override
	public boolean isSynchronized() {
		return methodDoc.isSynchronized()
	}

	@Override
	public boolean isVarArgs() {
		return methodDoc.isVarArgs()
	}

	@Override
	public ParamTag[] paramTags() {
		// TODO Auto-generated method stub
		return new ParamTag[0]
	}

	@Override
	public Parameter[] parameters() {
		GroovyParameter[] params = methodDoc.parameters()
		Parameter[] wrapped = new Parameter[params.length]
		params.eachWithIndex { 
			param,idx ->
			wrapped[idx] = new ParameterWrapper(param)
			}	
		return wrapped
	}

	@Override
	public String signature() {
		return methodDoc.signature()
	}

	@Override
	public Type[] thrownExceptionTypes() {
		GroovyType[] types = methodDoc.thrownExceptionTypes()
		Type[] wrapper = new Type[types.length]
		types.eachWithIndex { 
			typ, idx->
			wrapper[idx] = new TypeWrapper(typ)
		}		
		return wrapper  
	}

	@Override
	public ClassDoc[] thrownExceptions() {
		println "GETTING EXCEPTIONS"
		GroovyClassDoc[] classes = methodDoc.thrownExceptions()
		ClassDocWrapper[] wrapper = new ClassDocWrapper[classes.length]
		classes.eachWithIndex { 
			clazz,idx ->
			wrapper[idx] = new ClassDocWrapper(clazz)
			}
		
		return wrapper
	}

	@Override
	public ThrowsTag[] throwsTags() {
		// TODO Auto-generated method stub
		return new ThrowsTag[0]
	}

	@Override
	public ParamTag[] typeParamTags() {
		// TODO Auto-generated method stub
		return new ParamTag[0]
	}

	@Override
	public TypeVariable[] typeParameters() {
		// TODO Auto-generated method stub
		return new TypeVariable[0]
	}

	@Override
	public boolean isSynthetic() {
		// TODO Auto-generated method stub
		return false
	}

	@Override
	public AnnotationDesc[] annotations() {
		// TODO Auto-generated method stub
		return new AnnotationDesc[0]
	}

	@Override
	public ClassDoc containingClass() {
//		println "GETTING CONTAINING ${methodDoc.name()} - ${methodDoc.containingClass()} - ${methodDoc.containingClass()?.name()} - ${methodDoc.belongsToClass}"
		GroovyClassDoc clazz = methodDoc.containingClass()
		if(clazz == null){
			clazz = methodDoc.belongsToClass
		}
		return clazz!=null?new ClassDocWrapper(clazz):null
	}

	@Override
	public PackageDoc containingPackage() {
		return methodDoc.containingPackage()!=null?new PackageDocWrapper(methodDoc.containingPackage()):null
	}

	@Override
	public boolean isFinal() {
		return methodDoc.isFinal()
	}

	@Override
	public boolean isPackagePrivate() {
		return methodDoc.isPackagePrivate()
	}

	@Override
	public boolean isPrivate() {
		return methodDoc.isPrivate()
	}

	@Override
	public boolean isProtected() {
		return methodDoc.isProtected()
	}

	@Override
	public boolean isPublic() {
		return methodDoc.isPublic()
	}

	@Override
	public boolean isStatic() {
		return methodDoc.isStatic()
	}

	@Override
	public int modifierSpecifier() {
		return methodDoc.modifierSpecifier()
	}

	@Override
	public String modifiers() {		
		return methodDoc.modifiers()
	}

	@Override
	public String qualifiedName() {
		return methodDoc.qualifiedName()?:methodDoc.name()
	}

	@Override
	public String commentText() {
		return methodDoc.commentText()
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		if(Object instanceof MethodDoc){
			return -1
		}
		return 0
	}

	@Override
	public Tag[] firstSentenceTags() {
		// TODO Auto-generated method stub
		return new Tag[0]
	}

	@Override
	public String getRawCommentText() {
		return methodDoc.getRawCommentText()
	}

	@Override
	public Tag[] inlineTags() {
		return new Tag[0]
	}

	@Override
	public boolean isAnnotationType() {
		return methodDoc.isAnnotationType()
	}

	@Override
	public boolean isAnnotationTypeElement() {
		return methodDoc.isAnnotationTypeElement()
	}

	@Override
	public boolean isClass() {
		return methodDoc.isClass()
	}

	@Override
	public boolean isConstructor() {
		return methodDoc.isConstructor()
	}

	@Override
	public boolean isEnum() {
		return methodDoc.isEnum()
	}

	@Override
	public boolean isEnumConstant() {
		return methodDoc.isEnumConstant()
	}

	@Override
	public boolean isError() {
		return methodDoc.isError()
	}

	@Override
	public boolean isException() {
		return methodDoc.isException()
	}

	@Override
	public boolean isField() {
		return methodDoc.isField()
	}

	@Override
	public boolean isIncluded() {
		return methodDoc.isIncluded()
	}

	@Override
	public boolean isInterface() {
		return methodDoc.isInterface()
	}

	@Override
	public boolean isMethod() {
		return methodDoc.isMethod()
	}

	@Override
	public boolean isOrdinaryClass() {
		return methodDoc.isOrdinaryClass()
	}

	@Override
	public String name() {
		return methodDoc.name()?:"null"
	}

	@Override
	public SourcePosition position() {
		// TODO Auto-generated method stub
		return null
	}

	@Override
	public SeeTag[] seeTags() {
		// TODO Auto-generated method stub
		return new SeeTag[0]
	}

	@Override
	public void setRawCommentText(String arg0) {
		methodDoc.setRawCommentText(arg0)

	}

	@Override
	public Tag[] tags() {
		// TODO Auto-generated method stub
//		println "Asking for tags "
		return new Tag[0]
	}

	@Override
	public Tag[] tags(String arg0) {
		// TODO Auto-generated method stub
//		println "Asking for tags ${arg0}"
		return new Tag[0]
	}

	@Override
	public boolean isAbstract() {
		return methodDoc.isAbstract()
	}

	@Override
	public ClassDoc overriddenClass() {
		println "GETTING OVERRIDEN"
		return methodDoc.overriddenClass()!=null?new ClassDocWrapper(methodDoc.overriddenClass()):null
	}

	@Override
	public MethodDoc overriddenMethod() {
		return methodDoc.overriddenMethod()!=null?new MethodDocWrapper(methodDoc.overriddenMethod()):null
	}

	@Override
	public Type overriddenType() {
		return methodDoc.overriddenType()!=null?new TypeWrapper(methodDoc.overriddenType()):null
	}

	@Override
	public boolean overrides(MethodDoc arg0) {
		// TODO Auto-generated method stub
		return false
	}

	@Override
	public Type returnType() {
//		println "Return type ${methodDoc.returnType()} ${methodDoc.returnType() as GroovyType}"
		GroovyType type = methodDoc.returnType()
		return type!=null?new TypeWrapper(type):null
	}

}
