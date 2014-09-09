import grails.converters.JSON
import grails.converters.XML
import org.codehaus.groovy.grails.web.converters.configuration.ObjectMarshallerRegisterer
import org.gmobile.Phone
import org.gmobile.marshallers.PhoneMarshallerJsonCompact
import org.gmobile.marshallers.PhoneMarshallerXml
import org.gmobile.renderers.ApiCollectionRendererJson
import org.gmobile.renderers.ApiRendererJson

// Place your Spring DSL code here
beans = {
    customPhoneJsonMarshaller(ObjectMarshallerRegisterer) {
        marshaller = new PhoneMarshallerJsonCompact()
        converterClass = JSON
        priority = 1
    }

    customPhoneXmlMarshaller(ObjectMarshallerRegisterer) {
        marshaller = new PhoneMarshallerXml()
        converterClass = XML
        priority = 1
    }

    phoneRenderer(ApiRendererJson, Phone) {
        label = "phone"
    }

    phoneCollectionRenderer(ApiCollectionRendererJson, Phone) {
        label = "phones"
    }
}
