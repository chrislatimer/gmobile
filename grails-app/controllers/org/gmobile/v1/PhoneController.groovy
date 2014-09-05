package org.gmobile.v1

import grails.rest.RestfulController
import org.gmobile.Phone

class PhoneController extends RestfulController<Phone> {
    static namespace = 'v1'
    static responseFormats = ['json', 'xml']

    public PhoneController() {
        super(Phone)
    }

    def index() {
        def obj = ["message" : "v1 has been deprecated"]
        respond obj
    }

}
