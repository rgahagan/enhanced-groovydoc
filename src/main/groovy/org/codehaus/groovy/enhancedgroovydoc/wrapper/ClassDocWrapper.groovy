package org.codehaus.groovy.enhancedgroovydoc.wrapper


import org.codehaus.groovy.groovydoc.GroovyClassDoc;
import org.codehaus.groovy.groovydoc.GroovyConstructorDoc;
import org.codehaus.groovy.groovydoc.GroovyFieldDoc;
import org.codehaus.groovy.groovydoc.GroovyMethodDoc;
import org.codehaus.groovy.groovydoc.GroovyPackageDoc;
import org.codehaus.groovy.groovydoc.GroovyType;
import org.umlgraph.doclet.WrappedClassDoc;

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SourcePosition;
import com.sun.javadoc.Tag;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import com.sun.javadoc.WildcardType;

class ClassDocWrapper implements ClassDoc {

	GroovyClassDoc classDoc
	
	public ClassDocWrapper(GroovyClassDoc classDoc){
		if(classDoc == null){
			println "Warning null classdoc ${classDoc}"
			throw new IllegalArgumentException("DAMN")
		}
		this.classDoc=classDoc
	}
	
	@Override
	public AnnotationDesc[] annotations() {
		// TODO Auto-generated method stub
		return new AnnotationDesc[0]
	}

	@Override
	public ClassDoc containingClass() {
		GroovyClassDoc clazz = classDoc.containingClass()
		if(clazz==null){
//			println "containingClass() ${classDoc.name()} returning null "
			return null
		}
		else{
			return new ClassDocWrapper(clazz)
		}
	}

	@Override
	public PackageDoc containingPackage() {		
		return classDoc.containingPackage()!=null?new PackageDocWrapper(classDoc.containingPackage()):null
	}

	@Override
	public boolean isFinal() {
		return classDoc.isFinal()
	}

	@Override
	public boolean isPackagePrivate() {
		return classDoc.isPackagePrivate()
	}

	@Override
	public boolean isPrivate() {
		return classDoc.isPrivate()
	}

	@Override
	public boolean isProtected() {
		println "isProtected"
		return classDoc.isProtected()
	}

	@Override
	public boolean isPublic() {
		println "isPublic"
		return classDoc.isPublic()
	}

	@Override
	public boolean isStatic() {
		return classDoc.isStatic()
	}

	@Override
	public int modifierSpecifier() {
		return classDoc.modifierSpecifier()
	}

	@Override
	public String modifiers() {
		return classDoc.modifiers()
	}

	@Override
	public String qualifiedName() {
		return classDoc.qualifiedName()?:classDoc.name()
	}

	@Override
	public String commentText() {	
		return classDoc.commentText()
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return -1
	}

	@Override
	public Tag[] firstSentenceTags() {
		// TODO Auto-generated method stub
		return new Tag[0];
	}

	@Override
	public String getRawCommentText() {
		return classDoc.getRawCommentText()
	}

	@Override
	public Tag[] inlineTags() {
		// TODO Auto-generated method stub
		return new Tag[0];
	}

	@Override
	public boolean isAnnotationType() {
		return classDoc.isAnnotationType();
	}

	@Override
	public boolean isAnnotationTypeElement() {
		return classDoc.isAnnotationTypeElement();
	}

	@Override
	public boolean isClass() {
		return classDoc.isClass();
	}

	@Override
	public boolean isConstructor() {
		return classDoc.isConstructor();
	}

	@Override
	public boolean isEnum() {
		return classDoc.isConstructor();
	}

	@Override
	public boolean isEnumConstant() {
		return classDoc.isEnumConstant()
	}

	@Override
	public boolean isError() {
		return classDoc.isError();
	}

	@Override
	public boolean isException() {
		return classDoc.isException();
	}

	@Override
	public boolean isField() {
		return classDoc.isField();
	}

	@Override
	public boolean isIncluded() {
//		println "Is included ${classDoc.name()} - ${classDoc.isIncluded()}"
		return classDoc.isIncluded();
	}

	@Override
	public boolean isInterface() {
		return classDoc.isInterface();
	}

	@Override
	public boolean isMethod() {
		return classDoc.isMethod();
	}

	@Override
	public boolean isOrdinaryClass() {
		boolean ordinary = classDoc.isOrdinaryClass()
		if(!ordinary && !classDoc.isInterface() &&
			!classDoc.isException() && !classDoc.isError()
			&& !classDoc.isAnnotationType() && !classDoc.isEnum()) {
			ordinary=true
		}
		return ordinary
	}

	@Override
	public String name() {
		return classDoc.name()?:"null";
	}

	@Override
	public SourcePosition position() {
		// TODO Auto-generated method stub
		println "Asking position"
		return null;
	}

	@Override
	public SeeTag[] seeTags() {
		// TODO Auto-generated method stub
		return new SeeTag[0];
	}

	@Override
	public void setRawCommentText(String txt) {
		classDoc.setRawCommentText(txt)

	}

	@Override
	public Tag[] tags() {
		// TODO Auto-generated method stub
//		println "Asking for tags"
		return new Tag[0];
	}

	@Override
	public Tag[] tags(String arg0) {
		// TODO Auto-generated method stub
//		println "Asking for tags ${arg0}"
		return new Tag[0];
	}

	@Override
	public AnnotationTypeDoc asAnnotationTypeDoc() {
		// TODO Auto-generated method stub
		println "Asking asAnnotationTypeDoc"
		return null;
	}

	@Override
	public ClassDoc asClassDoc() {		
		return this;
	}

	@Override
	public ParameterizedType asParameterizedType() {
		// TODO Auto-generated method stub
		println "Asking asParameterizedType"
		return null;
	}

	@Override
	public TypeVariable asTypeVariable() {
		// TODO Auto-generated method stub
		println "Asking as TypeVariable"
		return null;
	}

	@Override
	public WildcardType asWildcardType() {
		// TODO Auto-generated method stub
		println "Asking as WildcardType"
		return null;
	}

	@Override
	public String dimension() {
		// TODO Auto-generated method stub
		println "Asking dimension"
		return null;
	}

	@Override
	public boolean isPrimitive() {
		return classDoc.isPrimitive();
	}

	@Override
	public String qualifiedTypeName() {
		return classDoc.qualifiedTypeName();
	}

	@Override
	public String simpleTypeName() {
		return classDoc.simpleTypeName();
	}

	@Override
	public String typeName() {
		return classDoc.typeName();
	}

	@Override
	public ConstructorDoc[] constructors() {
		GroovyConstructorDoc[] consts = classDoc.constructors()
		ConstructorDoc[] wrapped = new ConstructorDoc[consts.length]
		consts.eachWithIndex { 
			cont, idx ->
			wrapped[idx] = new ConstructorDocWrapper(cont)	
		}
		return wrapped
	}

	@Override
	public ConstructorDoc[] constructors(boolean arg0) {
		GroovyConstructorDoc[] consts = classDoc.constructors(arg0)
		ConstructorDoc[] wrapped = new ConstructorDoc[consts.length]
		consts.eachWithIndex { 
			cont, idx ->
			wrapped[idx] = new ConstructorDocWrapper(cont)	
		}
		return wrapped
	}

	@Override
	public boolean definesSerializableFields() {
		return classDoc.definesSerializableFields();
	}

	@Override
	public FieldDoc[] enumConstants() {
		GroovyFieldDoc[] fields = classDoc.enumConstants()
		FieldDoc[] wrapper = new FieldDoc[fields.length]
		fields.eachWithIndex { 
			fil,idx ->
			wrapper[idx] = new FieldDocWrapper(fil)
			}
		
		return wrapper
	}

	@Override
	public FieldDoc[] fields() {
		GroovyFieldDoc[] fields = classDoc.fields()
		FieldDoc[] wrapper = new FieldDoc[fields.length]
		fields.eachWithIndex { 
			fil,idx ->
			wrapper[idx] = new FieldDocWrapper(fil)
			}
		
		return wrapper
	}

	@Override
	public FieldDoc[] fields(boolean arg0) {
		GroovyFieldDoc[] fields = classDoc.fields(arg0)
		FieldDoc[] wrapper = new FieldDoc[fields.length]
		fields.eachWithIndex { 
			fil,idx ->
			wrapper[idx] = new FieldDocWrapper(fil)
			}
		
		return wrapper
	}

	@Override
	public ClassDoc findClass(String arg0) {
		GroovyClassDoc clazz = classDoc.findClass(arg0)
		if(clazz!=null){
			return new ClassDocWrapper(clazz)
		}
		else{
			println "findClass(${arg0}) ${classDoc.name()} returning null "
			return null
		}
		
	}

	@Override
	public ClassDoc[] importedClasses() {
		GroovyClassDoc[] classes = classDoc.importedClasses()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex { 
			clazz,idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
			}
		return wrapped
	}

	@Override
	public PackageDoc[] importedPackages() {
		GroovyPackageDoc[] packs = classDoc.importedPackages()
		PackageDoc[] wrapped = new PackageDoc[packs.length]
		packs.eachWithIndex { 
			pack,idx->
			wrapped[idx]=new PackageDocWrapper(pack)	
		}
		return wrapped
	}

	@Override
	public ClassDoc[] innerClasses() {
		GroovyClassDoc[] classes = classDoc.innerClasses()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex { 
			clazz,idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
			}
		return wrapped
	}

	@Override
	public ClassDoc[] innerClasses(boolean arg0) {
		GroovyClassDoc[] classes = classDoc.innerClasses(arg0)
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex { 
			clazz,idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
			}
		return wrapped
	}

	@Override
	public Type[] interfaceTypes() {
		GroovyType[] types = classDoc.interfaceTypes()
		TypeWrapper[] wrapper = new TypeWrapper[types?.length?:0]
		types.eachWithIndex{
			typ,idx ->
			wrapper[idx] = new TypeWrapper(typ)
		}
		return wrapper
	}

	@Override
	public ClassDoc[] interfaces() {
		GroovyClassDoc[] classes = classDoc.interfaces()
		ClassDoc[] wrapped = new ClassDoc[classes.length]
		classes.eachWithIndex {
			clazz,idx ->
			wrapped[idx] = new ClassDocWrapper(clazz)
			}
		return wrapped
	}

	@Override
	public boolean isAbstract() {
		return classDoc.isAbstract()
	}

	@Override
	public boolean isExternalizable() {
		return classDoc.isExternalizable()
	}

	@Override
	public boolean isSerializable() {
		return classDoc.isSerializable()
	}

	@Override
	public MethodDoc[] methods() {
		GroovyMethodDoc[] methods = classDoc.methods()
		MethodDoc[] wrapper = new MethodDoc[methods.length]
		methods.eachWithIndex { 
			met,idx ->
			wrapper[idx]=new MethodDocWrapper(met)	
		}
		 
		return wrapper
	}

	@Override
	public MethodDoc[] methods(boolean arg0) {
		GroovyMethodDoc[] methods = classDoc.methods(arg0)
		MethodDoc[] wrapper = new MethodDoc[methods.length]
		methods.eachWithIndex { 
			met,idx ->
			wrapper[idx]=new MethodDocWrapper(met)	
		}
		 
		return wrapper
	}

	@Override
	public FieldDoc[] serializableFields() {
		GroovyFieldDoc[] fields = classDoc.serializableFields()
		FieldDoc[] wrapper = new FieldDoc[fields.length]
		fields.eachWithIndex { 
			fil,idx ->
			wrapper[idx] = new FieldDocWrapper(fil)
			}
		
		return wrapper
	}

	@Override
	public MethodDoc[] serializationMethods() {
		GroovyMethodDoc[] methods = classDoc.serializationMethods()
		MethodDoc[] wrapper = new MethodDoc[methods.length]
		methods.eachWithIndex {
			met,idx ->
			wrapper[idx]=new MethodDocWrapper(met)
		}		 
		return wrapper
	}

	@Override
	public boolean subclassOf(ClassDoc arg0) {
		return classDoc.subclassOf(arg0)
	}

	@Override
	public ClassDoc superclass() {		
		//Returning null if there is no super class available
		if(!classDoc.superclass().name()){
//			println "superclass() ${classDoc.name()} returning null "
			return null
		}		
		else if(!classDoc.superClass()){
//			println "superclass() ${classDoc.name()} returning null "
			return null
		}
		else{
			return new ClassDocWrapper(classDoc.superclass())
		}
	}

	@Override
	public Type superclassType() {	
		return classDoc.superclassType()!=null?new TypeWrapper(classDoc.superclassType()):null
	}

	@Override
	public ParamTag[] typeParamTags() {
		// TODO Auto-generated method stub
		return new ParamTag[0];
	}

	@Override
	public TypeVariable[] typeParameters() {
		// TODO Auto-generated method stub
		return new TypeVariable[0];
	}
	
	public String toString(){
		return this.name()
	}

}
