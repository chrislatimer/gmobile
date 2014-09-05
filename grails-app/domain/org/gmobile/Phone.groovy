package org.gmobile

import grails.rest.Resource

@Resource(uri="/phones", formats=["json", "xml"])
class Phone {

    String name
    String description

    static hasMany = [variations: Variation]
    static belongsTo = [manufacturer:Manufacturer]

    static constraints = {
        description nullable: true
    }
}
