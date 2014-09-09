package org.gmobile.renderers

import grails.rest.render.ContainerRenderer
import org.codehaus.groovy.grails.web.mime.MimeType


class ApiCollectionRendererJson extends ApiRendererJson implements ContainerRenderer {
    final Class componentType

    public ApiCollectionRendererJson(Class componentType) {
        super(Collection)
        this.componentType = componentType
    }

    public ApiCollectionRendererJson(Class componentType, MimeType... mimeTypes) {
        super(Collection, mimeTypes)
        this.componentType = componentType
    }
}
