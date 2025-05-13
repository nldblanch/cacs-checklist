package com.v1.cacs_checklist.models;

public class Field {
    String fieldName;
    String response;

    public Field(String fieldName, String response) {
        this.fieldName = fieldName;
        this.response = response;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}


