package org.gmobile.marshallers

import org.gmobile.Phone
import org.springframework.http.HttpMethod

class PhoneMarshallerJson extends NamedMarshallerJson {

    public static marshal = { linkGenerator, Phone phone ->
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
        map.links = []
        map.links << [rel:"self", href:linkGenerator.link(resource: phone, method: HttpMethod.GET, absolute: true),
                      uri:linkGenerator.link(resource: phone, method: HttpMethod.GET)]
        map.links << [rel:"manufacturer", href:linkGenerator.link(resource: phone.manufacturer, method: HttpMethod.GET, absolute: true),
                      uri:linkGenerator.link(resource: phone.manufacturer, method: HttpMethod.GET)]
        map
    }

    public PhoneMarshallerJson() {
        super(Phone, marshal)
    }
}
