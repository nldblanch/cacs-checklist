package com.v1.cacs_checklist.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document
public class Template {
    @Id
    String templateId;
    String templateName;
    List<Fieldset> fields;
    String ownerName;
    String ownerEmail;

    public Template(String templateId, String templateName, List<Fieldset> fields, String ownerName, String ownerEmail) {
        this.templateId = templateId;
        this.templateName = templateName;
        this.fields = fields;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<Fieldset> getFields() {
        return fields;
    }

    public void setFields(List<Fieldset> fields) {
        this.fields = fields;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    static class Fieldset {

        String fieldName;
        boolean required;
        String dataType;
        List<String> options = new ArrayList<String>();

        public Fieldset() {}
        public Fieldset(String fieldName, String dataType, boolean required) {
            this.fieldName = fieldName;
            this.dataType = dataType;
            this.required = required;
        }

        public Fieldset(String fieldName, String dataType, boolean required, List<String> options) {
            this.fieldName = fieldName;
            this.dataType = dataType;
            this.required = required;
            this.options = options;
        }

        public String getFieldName() {
            return fieldName;
        }

        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }

        public boolean isRequired() {
            return required;
        }

        public void setRequired(boolean required) {
            this.required = required;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public List<String> getOptions() {
            return options;
        }

        public void setOptions(List<String> options) {
            this.options = options;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Fieldset fieldset = (Fieldset) obj;
            return Objects.equals(fieldName, fieldset.fieldName) &&
                    Objects.equals(dataType, fieldset.dataType) &&
                    required == fieldset.required;
        }

        @Override
        public int hashCode() {
            return Objects.hash(fieldName, dataType, required);
        }

    }
}


