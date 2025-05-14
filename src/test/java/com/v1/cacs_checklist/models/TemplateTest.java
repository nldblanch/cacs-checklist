
package com.v1.cacs_checklist.models;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemplateTest {

    @Test
    void givenConstructor_whenObjectCreated_thenFieldsAreSetCorrectly() throws NoSuchFieldException, IllegalAccessException {
        // Create the initial object
        Template template = new Template(
                "TPL001", "Safety Audit",
                List.of(new Template.Fieldset("Fire Hazard", "boolean", true)),
                "Alice", "alice@example.com"
        );

        //Use reflection to get fields
        final java.lang.reflect.Field templateIdField = template.getClass().getDeclaredField("templateId");
        final java.lang.reflect.Field templateNameField = template.getClass().getDeclaredField("templateName");
        final java.lang.reflect.Field fieldsField = template.getClass().getDeclaredField("fields");
        final java.lang.reflect.Field ownerNameField = template.getClass().getDeclaredField("ownerName");
        final java.lang.reflect.Field ownerEmailField = template.getClass().getDeclaredField("ownerEmail");

        // Make fields accessible
        templateIdField.setAccessible(true);
        templateNameField.setAccessible(true);
        fieldsField.setAccessible(true);
        ownerNameField.setAccessible(true);
        ownerEmailField.setAccessible(true);

        // Assertions
        assertEquals("TPL001", templateIdField.get(template), "Fields didn't match");
        assertEquals("Safety Audit", templateNameField.get(template), "Fields didn't match");
        assertEquals(List.of(new Template.Fieldset("Fire Hazard", "boolean", true)), fieldsField.get(template), "Fields didn't match");
        assertEquals("Alice", ownerNameField.get(template), "Fields didn't match");
        assertEquals("alice@example.com", ownerEmailField.get(template), "Fields didn't match");

    }

    @Test
    public void givenTemplate_whenUsingReflection_thenGettersAndSettersWork() throws Exception {
        // Create an initial Template object
        Template template = new Template(
                "TPL001", "Safety Audit",
                List.of(new Template.Fieldset("Fire Hazard", "boolean", true)),
                "Alice", "alice@example.com"
        );

        // Reflection-based setter calls
        invokeSetter(template, "setTemplateId", String.class, "TPL002");
        invokeSetter(template, "setTemplateName", String.class, "Updated Audit");
        invokeSetter(template, "setFields", List.class, List.of(new Template.Fieldset("Emergency Exit", "boolean", true)));
        invokeSetter(template, "setOwnerName", String.class, "Updated Alice");
        invokeSetter(template, "setOwnerEmail", String.class, "updated_alice@example.com");

        // Reflection-based getter assertions
        assertEquals("TPL002", invokeGetter(template, "getTemplateId"));
        assertEquals("Updated Audit", invokeGetter(template, "getTemplateName"));
        assertEquals(List.of(new Template.Fieldset("Emergency Exit", "boolean", true)), invokeGetter(template, "getFields"));
        assertEquals("Updated Alice", invokeGetter(template, "getOwnerName"));
        assertEquals("updated_alice@example.com", invokeGetter(template, "getOwnerEmail"));
    }

    @Test
    void givenFieldsetConstructor_whenObjectCreated_thenFieldsAreSetCorrectly() throws NoSuchFieldException, IllegalAccessException {
        // Create the initial object
        Template.Fieldset fieldset = new Template.Fieldset(
                "Fire Hazard", "boolean", true
        );

        //Use reflection to get fields
        final java.lang.reflect.Field fieldNameField = fieldset.getClass().getDeclaredField("fieldName");
        final java.lang.reflect.Field dataTypeField = fieldset.getClass().getDeclaredField("dataType");
        final java.lang.reflect.Field requiredField = fieldset.getClass().getDeclaredField("required");

        // Make fields accessible
        fieldNameField.setAccessible(true);
        dataTypeField.setAccessible(true);
        requiredField.setAccessible(true);

        // Assertions
        assertEquals("Fire Hazard", fieldNameField.get(fieldset), "Fields didn't match");
        assertEquals("boolean", dataTypeField.get(fieldset), "Fields didn't match");
        assertEquals(true, requiredField.get(fieldset), "Fields didn't match");

    }

    void givenFieldsetConstructorWithExtraField_whenObjectCreated_thenFieldsAreSetCorrectly() throws NoSuchFieldException, IllegalAccessException {
        // Create the initial object
        Template.Fieldset fieldset = new Template.Fieldset(
                "Fire Hazard", "boolean", true, List.of("Yes", "No")
        );

        //Use reflection to get fields
        final java.lang.reflect.Field fieldNameField = fieldset.getClass().getDeclaredField("fieldName");
        final java.lang.reflect.Field dataTypeField = fieldset.getClass().getDeclaredField("dataType");
        final java.lang.reflect.Field requiredField = fieldset.getClass().getDeclaredField("required");
        final java.lang.reflect.Field optionsField = fieldset.getClass().getDeclaredField("options");

        // Make fields accessible
        fieldNameField.setAccessible(true);
        dataTypeField.setAccessible(true);
        requiredField.setAccessible(true);
        optionsField.setAccessible(true);

        // Assertions
        assertEquals("Fire Hazard", fieldNameField.get(fieldset), "Fields didn't match");
        assertEquals("boolean", dataTypeField.get(fieldset), "Fields didn't match");
        assertEquals(true, requiredField.get(fieldset), "Fields didn't match");
        assertEquals(List.of("Yes", "No"), optionsField.get(fieldset), "Fields didn't match");

    }

    @Test
    public void givenFieldset_whenUsingReflection_thenGettersAndSettersWork() throws Exception {
        // Create an initial Fieldset object
        Template.Fieldset fieldset = new Template.Fieldset("Fire Hazard", "boolean", true);

        // Reflection-based setter calls
        invokeSetter(fieldset, "setFieldName", String.class, "Emergency Exit");
        invokeSetter(fieldset, "setDataType", String.class, "string");
        invokeSetter(fieldset, "setRequired", boolean.class, false);
        invokeSetter(fieldset, "setOptions", List.class, List.of("Yes", "No"));

        // Reflection-based getter assertions
        assertEquals("Emergency Exit", invokeGetter(fieldset, "getFieldName"));
        assertEquals("string", invokeGetter(fieldset, "getDataType"));
        assertEquals(false, invokeGetter(fieldset, "isRequired"));
        assertEquals(List.of("Yes", "No"), invokeGetter(fieldset, "getOptions"));
    }

    // Helper method to invoke setters with proper type resolution
    private void invokeSetter(Object obj, String methodName, Class<?> paramType, Object value) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, paramType);
        method.invoke(obj, value);
    }

    // Helper method to invoke getters
    private Object invokeGetter(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName);
        return method.invoke(obj);
    }
}
