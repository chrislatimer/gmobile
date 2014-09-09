package org.gmobile.renderers

import grails.converters.JSON
import grails.rest.render.AbstractRenderer
import grails.rest.render.ContainerRenderer
import grails.rest.render.RenderContext
import grails.util.GrailsWebUtil
import org.codehaus.groovy.grails.web.json.JSONWriter
import org.codehaus.groovy.grails.web.mime.MimeType
import org.gmobile.converters.ApiJSON

class ApiRendererJson<T> extends AbstractRenderer<T> {

    String label

    public ApiRendererJson(Class<T> targetClass) {
        super(targetClass, MimeType.JSON);
    }

    @Override
    void render(T object, RenderContext context) {
        context.setContentType(GrailsWebUtil.getContentType(MimeType.JSON.name, GrailsWebUtil.DEFAULT_ENCODING))
        ApiJSON converter
        def detail = context.arguments?.detail ?: "compact"
        def out = context.writer
        JSONWriter writer = new JSONWriter(out)

        JSON.use(detail) {
            converter = object as ApiJSON
        }

        writer.object()
        writer.key(getLabel())
        converter.renderPartial(writer)

        if(context.arguments?.paging) {
            writer.key("paging")
            converter = context.arguments.paging as ApiJSON
            converter.renderPartial(writer)
        }
        writer.endObject()

        out.flush()
        out.close()
    }

    String getLabel() {
        if(label) {
            label
        }
        else if(this instanceof ContainerRenderer) {
            "entities"
        }
        else {
            "entity"
        }
    }
}
