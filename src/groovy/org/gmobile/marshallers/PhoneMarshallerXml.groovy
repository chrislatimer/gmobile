package org.gmobile.marshallers

import grails.converters.XML
import org.codehaus.groovy.grails.web.converters.marshaller.ClosureObjectMarshaller
import org.gmobile.Phone

class PhoneMarshallerXml extends ClosureObjectMarshaller<XML>{

    def static final marshal = { Phone phone, XML xml ->
        xml.build {
            name(phone.name)
        }
    }

    public PhoneMarshallerXml() {
        super(Phone, marshal)
    }
}
