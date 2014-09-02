package org.gmobile

class Phone {

    String name

    static belongsTo = [manufacturer:Manufacturer]

    static constraints = {
    }
}
