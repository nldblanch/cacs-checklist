package com.v1.cacs_checklist.models;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Field field = (Field) obj;
        return Objects.equals(fieldName, field.fieldName) && Objects.equals(response, field.response);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, response);
    }

}


