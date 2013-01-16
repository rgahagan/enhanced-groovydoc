package org.codehaus.groovy.enhancedgroovydoc.wrapper


import org.codehaus.groovy.groovydoc.GroovyParameter;
import org.codehaus.groovy.groovydoc.GroovyType;

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.Type;

class ParameterWrapper implements Parameter {

	GroovyParameter param
	
	public ParameterWrapper(GroovyParameter par){
		param=par
	}
	
	@Override
	public AnnotationDesc[] annotations() {
		// TODO Auto-generated method stub
		return new AnnotationDesc[0];
	}

	@Override
	public String name() {	
		return param.name()?:"null"
	}

	@Override
	public Type type() {
		GroovyType type = param.type()
		if(!type){ 
			type=[
				typeName:{ -> return "void" }
				] as GroovyType
		} 
		return type!=null?new TypeWrapper(type):null
	}

	@Override
	public String typeName() {
		return param.typeName()
	}

}
