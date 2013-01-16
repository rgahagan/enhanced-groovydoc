package org.codehaus.groovy.enhancedgroovydoc.wrapper

import org.codehaus.groovy.groovydoc.GroovyType



import com.sun.javadoc.AnnotationTypeDoc
import com.sun.javadoc.ClassDoc
import com.sun.javadoc.ParameterizedType
import com.sun.javadoc.Type
import com.sun.javadoc.TypeVariable
import com.sun.javadoc.WildcardType

class TypeWrapper implements Type {

	GroovyType type
	
	public TypeWrapper(GroovyType typ){
		type = typ
	}
	
	
	@Override
	public AnnotationTypeDoc asAnnotationTypeDoc() {
		// TODO Auto-generated method stub		
		return null
	}

	@Override
	public ClassDoc asClassDoc() {
		// TODO Auto-generated method stub
		return null
	}

	@Override
	public ParameterizedType asParameterizedType() {
		// TODO Auto-generated method stub
		return null
	}

	@Override
	public TypeVariable asTypeVariable() {
		// TODO Auto-generated method stub	
		return null
	}

	@Override
	public WildcardType asWildcardType() {
		// TODO Auto-generated method stub
		return null
	}

	@Override
	public String dimension() {
		// TODO Auto-generated method stub
		return ""
	}

	@Override
	public boolean isPrimitive() {
		return type.isPrimitive()
	}

	@Override
	public String qualifiedTypeName() {
		return type.qualifiedTypeName()
	}

	@Override
	public String simpleTypeName() {
		return type.simpleTypeName()
	}

	@Override
	public String typeName() {
		if(type.typeName()==null){
			return type.qualifiedTypeName()
		}
		return type.typeName()
	}

}
