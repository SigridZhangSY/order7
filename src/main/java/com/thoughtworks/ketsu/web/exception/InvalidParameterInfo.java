package com.thoughtworks.ketsu.web.exception;

import com.thoughtworks.ketsu.infrastructure.records.Record;
import com.thoughtworks.ketsu.web.jersey.Routes;

import java.util.HashMap;
import java.util.Map;

public class InvalidParameterInfo implements Record {
    private String field;


    public InvalidParameterInfo(String parameters){
        this.field = parameters;
    }


    @Override
    public Map<String, Object> toRefJson(Routes routes) {
        return null;
    }

    @Override
    public Map<String, Object> toJson(Routes routes) {
        return new HashMap<String, Object>(){{
            put("field", field);
            put("message", field + " can not be empty");
        }};
    }
}
