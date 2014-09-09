package org.gmobile.converters

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONWriter

class ApiJSON extends JSON {

    public ApiJSON() {
        super()
    }

    public ApiJSON(Object target) {
        super(target)
    }

    public void renderPartial(JSONWriter out) {
        initWriter(out)
        super.value(target)
    }

    protected initWriter(JSONWriter out) {
        writer = out
        referenceStack = new Stack<Object>();
    }
}
