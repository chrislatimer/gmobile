package org.gmobile

class Manufacturer {
    String name

    static hasMany = [phones:Phone]
    static constraints = {

    }
}
