
package com.v1.cacs_checklist.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTest {



    @Test
    void testFieldConstructorAndGetters() {
        // Given
        String expectedFieldName = "ChecklistItem";
        String expectedResponse = "Yes";

        // When
        Field field = new Field(expectedFieldName, expectedResponse);

        // Then (using reflection since no getters are provided)
        try {
            var fieldNameField = Field.class.getDeclaredField("fieldName");
            var responseField = Field.class.getDeclaredField("response");

            fieldNameField.setAccessible(true);
            responseField.setAccessible(true);

            assertEquals(expectedFieldName, fieldNameField.get(field));
            assertEquals(expectedResponse, responseField.get(field));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}
