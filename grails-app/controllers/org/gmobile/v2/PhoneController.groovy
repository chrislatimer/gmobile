package org.gmobile.v2

import grails.converters.JSON
import grails.rest.RestfulController
import org.gmobile.Phone

class PhoneController extends RestfulController<Phone> {
    static namespace = 'v2'
    static responseFormats = ['json', 'xml']

    public PhoneController() {
        super(Phone)
    }

}