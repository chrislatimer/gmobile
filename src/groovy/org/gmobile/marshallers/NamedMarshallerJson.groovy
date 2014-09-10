package org.gmobile.marshallers

import grails.converters.JSON

class NamedMarshallerJson extends NamedMarshaller {

    public NamedMarshallerJson(Class clazz, Closure closure) {
        super(JSON, clazz, closure)
    }
}
