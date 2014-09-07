package org.gmobile.marshallers

import grails.converters.JSON
import org.codehaus.groovy.grails.web.converters.marshaller.ClosureObjectMarshaller
import org.gmobile.Phone

class PhoneMarshallerJsonCompact extends ClosureObjectMarshaller<JSON>{

    public static final marshal = { Phone phone ->
        def map = [:]
        map.id = phone.id
        map.name = phone.name
        map
    }

    public PhoneMarshallerJsonCompact() {
        super(Phone, marshal)
    }

}
