package org.gmobile

import grails.rest.Resource

@Resource(uri='/manufacturers')
class Manufacturer {
    String name

    static hasMany = [phones:Phone]
    static constraints = {

    }
}
