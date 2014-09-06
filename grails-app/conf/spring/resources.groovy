import grails.converters.JSON
import grails.converters.XML
import org.codehaus.groovy.grails.web.converters.configuration.ObjectMarshallerRegisterer
import org.gmobile.marshallers.PhoneMarshallerJson
import org.gmobile.marshallers.PhoneMarshallerXml

// Place your Spring DSL code here
beans = {
    customPhoneJsonMarshaller(ObjectMarshallerRegisterer) {
        marshaller = new PhoneMarshallerJson()
        converterClass = JSON
        priority = 1
    }

    customPhoneXmlMarshaller(ObjectMarshallerRegisterer) {
        marshaller = new PhoneMarshallerXml()
        converterClass = XML
        priority = 1
    }
}
