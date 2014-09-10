import org.gmobile.Phone
import org.gmobile.marshallers.PhoneMarshallerJson
import org.gmobile.marshallers.PhoneMarshallerJsonCompact
import org.gmobile.renderers.ApiCollectionRendererJson
import org.gmobile.renderers.ApiRendererJson

// Place your Spring DSL code here
beans = {
    customPhoneJsonMarshaller(PhoneMarshallerJson) {
        name = "complete"
    }

    customPhoneJsonMarshallerCompact(PhoneMarshallerJsonCompact) {
        name = "compact"
    }

    phoneRenderer(ApiRendererJson, Phone) {
        label = "phone"
    }

    phoneCollectionRenderer(ApiCollectionRendererJson, Phone) {
        label = "phones"
    }
}
