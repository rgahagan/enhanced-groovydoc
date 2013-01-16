package org.codehaus.groovy.enhancedgroovydoc.wrapper


import org.codehaus.groovy.groovydoc.GroovyClassDoc 
import org.codehaus.groovy.groovydoc.GroovyFieldDoc

import com.sun.javadoc.AnnotationDesc
import com.sun.javadoc.ClassDoc
import com.sun.javadoc.FieldDoc
import com.sun.javadoc.PackageDoc
import com.sun.javadoc.SeeTag
import com.sun.javadoc.SerialFieldTag
import com.sun.javadoc.SourcePosition
import com.sun.javadoc.Tag
import com.sun.javadoc.Type

class FieldDocWrapper implements FieldDoc {

	GroovyFieldDoc field
	
	public FieldDocWrapper(GroovyFieldDoc fld){
		field = fld
	}
	
	@Override
	public boolean isSynthetic() {
		return field.isSynthetic()
	}

	@Override
	public AnnotationDesc[] annotations() {
		// TODO Auto-generated method stub
		return new AnnotationDesc[0]
	}

	@Override
	public ClassDoc containingClass() {
//		println "GETTING CONTAINING CLASS"
//		return field.containingClass()!=null?new ClassDocWrapper(field.containingClass()):null
//		println "GETTING CONTAINING ${field.name()} - ${field.containingClass()} - ${field.containingClass()?.name()} - ${field.belongsToClass}"
		GroovyClassDoc clazz = field.containingClass()
		if(clazz == null){
			clazz = field.belongsToClass
		}
		return clazz!=null?new ClassDocWrapper(clazz):null
	}

	@Override
	public PackageDoc containingPackage() {		
		return field.containingPackage()!=null?new PackageDocWrapper(field.containingPackage()):null
	}

	@Override
	public boolean isFinal() {
		return field.isFinal()
	}

	@Override
	public boolean isPackagePrivate() {
		return field.isPackagePrivate()
	}

	@Override
	public boolean isPrivate() {
		return field.isPrivate()
	}

	@Override
	public boolean isProtected() {
		return field.isProtected()
	}

	@Override
	public boolean isPublic() {
		return field.isPublic()
	}

	@Override
	public boolean isStatic() {
		return field.isStatic()
	}

	@Override
	public int modifierSpecifier() {
		return field.modifierSpecifier()
	}

	@Override
	public String modifiers() {
		return field.modifiers()
	}

	@Override
	public String qualifiedName() {
		return field.qualifiedName()?:field.name()
	}

	@Override
	public String commentText() {
		return field.commentText()
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return -1
	}

	@Override
	public Tag[] firstSentenceTags() {
		return new Tag[0]
	}

	@Override
	public String getRawCommentText() {		
		return field.getRawCommentText()
	}

	@Override
	public Tag[] inlineTags() {
		return new Tag[0]
	}

	@Override
	public boolean isAnnotationType() {
		return field.isAnnotationType()
	}

	@Override
	public boolean isAnnotationTypeElement() {
		return field.isAnnotationTypeElement()
	}

	@Override
	public boolean isClass() {
		return field.isClass()
	}

	@Override
	public boolean isConstructor() {
		return field.isConstructor()
	}

	@Override
	public boolean isEnum() {
		return field.isEnum()
	}

	@Override
	public boolean isEnumConstant() {
		return field.isEnumConstant()
	}

	@Override
	public boolean isError() {
		return field.isError()
	}

	@Override
	public boolean isException() {
		return field.isException()
	}

	@Override
	public boolean isField() {
		return field.isField()
	}

	@Override
	public boolean isIncluded() {
		return field.isIncluded()
	}

	@Override
	public boolean isInterface() {
		return field.isInterface()
	}

	@Override
	public boolean isMethod() {
		return field.isMethod()
	}

	@Override
	public boolean isOrdinaryClass() {
		return field.isOrdinaryClass()
	}

	@Override
	public String name() {
		return field.name()?:"null"
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
		field.setRawCommentText(arg0)

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
	public Object constantValue() {
		return field.constantValue()
	}

	@Override
	public String constantValueExpression() {
		return field.constantValueExpression()
	}

	@Override
	public boolean isTransient() {
		return field.isTransient()
	}

	@Override
	public boolean isVolatile() {
		return field.isVolatile()
	}

	@Override
	public SerialFieldTag[] serialFieldTags() {
		// TODO Auto-generated method stub
		return new SerialFieldTag[0]
	}

	@Override
	public Type type() {		
		return field.type()!=null?new TypeWrapper(field.type()):null
	}

}
