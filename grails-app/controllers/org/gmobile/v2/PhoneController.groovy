package org.gmobile.v2

import grails.converters.JSON
import grails.converters.XML
import grails.rest.RestfulController
import org.gmobile.Phone

class PhoneController extends RestfulController<Phone> {
    static namespace = 'v2'
    static responseFormats = ['json', 'xml']

    public PhoneController() {
        super(Phone)
    }

    def show(Phone phone) {
        def detail = params.detail ?: "complete"
        withFormat {
            json {
                respond(phone, [detail:detail])
            }
            xml {
                XML.use(params?.detail?.toLowerCase() ?: "complete") {
                    respond phone
                }
            }
        }
    }

    def index() {
        params.max = Math.min(params.max ?: 10, 100)
        def detail = params?.detail?.toLowerCase() ?: "compact"
        withFormat {
            json {
                respond Phone.list(params), [detail:detail]
            }
            xml {
                XML.use(detail) {
                    respond phone
                }
            }
        }
    }
}
