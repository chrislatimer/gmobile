package org.gmobile.marshallers

import grails.converters.JSON
import org.codehaus.groovy.grails.web.converters.marshaller.ClosureObjectMarshaller
import org.gmobile.Phone

class PhoneMarshallerJson extends ClosureObjectMarshaller<JSON> {

    static final marshal = { Phone phone ->
        def map = [:]
        map.name = phone.name
        map.manufacturer = [:]
        map.manufacturer.name = phone.manufacturer.name
        map.manufacturer.id = phone.manufacturer.id
        map.variations = []
        phone.variations.each { variation ->
            def v = [:]
            v.label = variation.label
            v.baseVariation = variation.baseVariation
            v.listPrice = variation.listPrice
            v.salePrice = variation.salePrice
            map.variations << v
        }
        map
    }

    public PhoneMarshallerJson() {
        super(Phone, marshal)
    }
}
