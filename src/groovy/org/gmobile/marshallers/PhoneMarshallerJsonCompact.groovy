package org.gmobile.marshallers
import org.codehaus.groovy.grails.web.mapping.LinkGenerator
import org.gmobile.Phone
import org.springframework.http.HttpMethod

class PhoneMarshallerJsonCompact  extends NamedMarshallerJson {

    public static final marshal = { LinkGenerator linkGenerator, Phone phone ->
        def map = [:]
        map.id = phone.id
        map.name = phone.name
        map.links = []
        map.links << [rel:"self", href:linkGenerator.link(resource: phone, method: HttpMethod.GET, absolute: true),
                      uri:linkGenerator.link(resource: phone, method: HttpMethod.GET)]
        map.links << [rel:"manufacturer", href:linkGenerator.link(resource: phone.manufacturer, method: HttpMethod.GET, absolute: true),
                      uri:linkGenerator.link(resource: phone.manufacturer, method: HttpMethod.GET)]
        map
    }

    public PhoneMarshallerJsonCompact() {
        super(Phone, marshal)
    }

}
