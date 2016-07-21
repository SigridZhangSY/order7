package com.thoughtworks.ketsu.web.exception;

import java.util.ArrayList;
import java.util.List;

public class InvalidParameterException extends RuntimeException {
    public List<InvalidParameterInfo> getInvalidParameterInfoList() {
        return invalidParameterInfoList;
    }

    private List<InvalidParameterInfo> invalidParameterInfoList;


    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(Exception e) {
        super(e);
    }

    public InvalidParameterException(List<String> fields){
        invalidParameterInfoList = new ArrayList<>();
        for(String field: fields){
            invalidParameterInfoList.add(new InvalidParameterInfo(field));
        }
    }
}