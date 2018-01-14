package org.talend.esb.eventlogging.sender.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

public class JsonProviderFactory {

    public Object getJsonProvider() {

        return new JacksonJaxbJsonProvider(
                new ObjectMapper()
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
                    //.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false)
                    .setSerializationInclusion(JsonInclude.Include.NON_NULL),
                JacksonJaxbJsonProvider.DEFAULT_ANNOTATIONS);
    }
}
