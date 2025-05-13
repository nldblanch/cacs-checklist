
package com.v1.cacs_checklist.models;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void givenConstructor_whenObjectCreated_thenFieldsAreSetCorrectly() throws NoSuchFieldException, IllegalAccessException {
        // Create the initial object
        Field field = new Field("Fire Extinguisher", "Yes");

        //Use reflection to get fields
        final java.lang.reflect.Field fieldNameField = field.getClass().getDeclaredField("fieldName");
        final java.lang.reflect.Field responseField = field.getClass().getDeclaredField("response");

        // Make fields accessible
        fieldNameField.setAccessible(true);
        responseField.setAccessible(true);

        // Assertions
        assertEquals("Fire Extinguisher", fieldNameField.get(field), "Fields didn't match");
        assertEquals("Yes", responseField.get(field), "Fields didn't match");
    }


    @Test
    public void givenField_whenUsingReflection_thenGettersAndSettersWork() throws Exception {
        // Create the initial object
        Field field = new Field("Fire Extinguisher", "Yes");

        // Reflection-based setter calls
        invokeSetter(field, "setFieldName", String.class, "Emergency Exit");
        invokeSetter(field, "setResponse", String.class, "Available");

        // Reflection-based getter assertions
        assertEquals("Emergency Exit", invokeGetter(field, "getFieldName"));
        assertEquals("Available", invokeGetter(field, "getResponse"));
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
