package org.gmobile.marshallers

import org.codehaus.groovy.grails.web.converters.Converter
import org.codehaus.groovy.grails.web.converters.configuration.DefaultConverterConfiguration
import org.codehaus.groovy.grails.web.converters.marshaller.ClosureObjectMarshaller
import org.codehaus.groovy.grails.web.converters.marshaller.ObjectMarshaller
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import org.springframework.beans.factory.annotation.Autowired

class NamedMarshaller {

    @Autowired
    LinkGenerator linkGenerator

    ObjectMarshaller marshaller
    Class<? extends Converter> converterClass
    int priority = DefaultConverterConfiguration.DEFAULT_PRIORITY;
    String name
    Closure closure
    Class clazz

    public NamedMarshaller(Class<? extends Converter> converterClass, Class clazz, Closure closure) {
        this.converterClass = converterClass
        this.clazz = clazz
        this.closure = closure
    }

    public ObjectMarshaller getMarshaller() {
        if(!marshaller) {
            if(this.closure.getMaximumNumberOfParameters() > 1) {
                this.marshaller = new ClosureObjectMarshaller(clazz, closure.curry(linkGenerator))
            }
            else {
                this.marshaller = new ClosureObjectMarshaller(clazz, closure)
            }
        }
        return this.marshaller
    }
}
