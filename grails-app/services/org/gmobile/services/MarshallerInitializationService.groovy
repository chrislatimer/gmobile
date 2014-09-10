package org.gmobile.services

import grails.converters.JSON
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.converters.configuration.ConvertersConfigurationHolder
import org.codehaus.groovy.grails.web.converters.configuration.DefaultConverterConfiguration
import org.gmobile.marshallers.NamedMarshallerJson
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

@Transactional
class MarshallerInitializationService implements ApplicationContextAware {
    ApplicationContext applicationContext

    public void initialize() {
        registerNamedJsonMarshallers()
    }

    protected registerNamedJsonMarshallers() {
        def configs = [:]
        for (Object o : applicationContext.getBeansOfType(NamedMarshallerJson.class).values()) {
            def c = ConvertersConfigurationHolder.getConverterConfiguration(JSON.class)
            NamedMarshallerJson namedMarshaller = (NamedMarshallerJson) o
            if(!configs[namedMarshaller.name]) {
                configs[namedMarshaller.name] = new DefaultConverterConfiguration<JSON>(c)
            }
            DefaultConverterConfiguration<JSON> cfg = configs[namedMarshaller.name]
            cfg.registerObjectMarshaller(namedMarshaller.marshaller)
            ConvertersConfigurationHolder.setNamedConverterConfiguration(JSON.class, namedMarshaller.name, cfg);
        }
    }
}
