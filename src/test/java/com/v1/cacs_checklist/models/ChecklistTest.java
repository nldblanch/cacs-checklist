package com.v1.cacs_checklist.models;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class ChecklistTest {

    @Test
    void givenConstructor_whenObjectCreated_thenFieldsAreSetCorrectly() throws NoSuchFieldException, IllegalAccessException {
        Checklist checklist = new Checklist("CHK001", "TEMPLATE001", "Safety Checklist", true, false, LocalDate.parse("2025-05-31"), LocalDate.parse("2025-05-01"), List.of(new Field("Fire Extinguisher", "Yes")), "Alice", "alice@example.com", "Bob", "bob@example.com", "Charlie", "charlie@example.com");
        final java.lang.reflect.Field checklistIdField = checklist.getClass().getDeclaredField("checklistId");
        final java.lang.reflect.Field checklistTemplateIdField = checklist.getClass().getDeclaredField("checklistTemplateId");
        final java.lang.reflect.Field checklistNameField = checklist.getClass().getDeclaredField("checklistName");
        final java.lang.reflect.Field submittedField = checklist.getClass().getDeclaredField("submitted");
        final java.lang.reflect.Field assessedField = checklist.getClass().getDeclaredField("assessed");
        final java.lang.reflect.Field dueDateField = checklist.getClass().getDeclaredField("dueDate");
        final java.lang.reflect.Field submissionDateField = checklist.getClass().getDeclaredField("submissionDate");
        final java.lang.reflect.Field fieldsField = checklist.getClass().getDeclaredField("fields");
        final java.lang.reflect.Field ownerNameField = checklist.getClass().getDeclaredField("ownerName");
        final java.lang.reflect.Field ownerEmailField = checklist.getClass().getDeclaredField("ownerEmail");
        final java.lang.reflect.Field submitterNameField = checklist.getClass().getDeclaredField("submitterName");
        final java.lang.reflect.Field submitterEmailField = checklist.getClass().getDeclaredField("submitterEmail");
        final java.lang.reflect.Field assessorNameField = checklist.getClass().getDeclaredField("assessorName");
        final java.lang.reflect.Field assessorEmailField = checklist.getClass().getDeclaredField("assessorEmail");

        // Make fields accessible
        checklistIdField.setAccessible(true);
        checklistTemplateIdField.setAccessible(true);
        checklistNameField.setAccessible(true);
        submittedField.setAccessible(true);
        assessedField.setAccessible(true);
        dueDateField.setAccessible(true);
        submissionDateField.setAccessible(true);
        fieldsField.setAccessible(true);
        ownerNameField.setAccessible(true);
        ownerEmailField.setAccessible(true);
        submitterNameField.setAccessible(true);
        submitterEmailField.setAccessible(true);
        assessorNameField.setAccessible(true);
        assessorEmailField.setAccessible(true);

        // Assertions
        assertEquals("CHK001", checklistIdField.get(checklist), "Fields didn't match");
        assertEquals("TEMPLATE001", checklistTemplateIdField.get(checklist), "Fields didn't match");
        assertEquals("Safety Checklist", checklistNameField.get(checklist), "Fields didn't match");
        assertEquals(true, submittedField.get(checklist), "Fields didn't match");
        assertEquals(false, assessedField.get(checklist), "Fields didn't match");
        assertEquals(LocalDate.parse("2025-05-31"), dueDateField.get(checklist), "Fields didn't match");
        assertEquals(LocalDate.parse("2025-05-01"), submissionDateField.get(checklist), "Fields didn't match");
        assertEquals(List.of(new Field("Fire Extinguisher", "Yes")), fieldsField.get(checklist), "Fields didn't match");
        assertEquals("Alice", ownerNameField.get(checklist), "Fields didn't match");
        assertEquals("alice@example.com", ownerEmailField.get(checklist), "Fields didn't match");
        assertEquals("Bob", submitterNameField.get(checklist), "Fields didn't match");
        assertEquals("bob@example.com", submitterEmailField.get(checklist), "Fields didn't match");
        assertEquals("Charlie", assessorNameField.get(checklist), "Fields didn't match");
        assertEquals("charlie@example.com", assessorEmailField.get(checklist), "Fields didn't match");
    }

    @Test
    public void givenChecklist_whenUsingReflection_thenGettersAndSettersWork() throws Exception {
        // Create the initial object
        Checklist checklist = new Checklist(
                "CHK001", "TEMPLATE001", "Safety Checklist", true, false,
                LocalDate.parse("2025-05-31"), LocalDate.parse("2025-05-01"),
                List.of(new Field("Fire Extinguisher", "Yes")),
                "Alice", "alice@example.com",
                "Bob", "bob@example.com",
                "Charlie", "charlie@example.com"
        );

        // Reflection-based setter calls
        invokeSetter(checklist, "setChecklistId", String.class, "CHK002");
        invokeSetter(checklist, "setChecklistTemplateId", String.class, "TEMPLATE002");
        invokeSetter(checklist, "setChecklistName", String.class, "Updated Checklist");
        invokeSetter(checklist, "setSubmitted", boolean.class, false);
        invokeSetter(checklist, "setAssessed", boolean.class, true);
        invokeSetter(checklist, "setDueDate", LocalDate.class, LocalDate.parse("2025-06-30"));
        invokeSetter(checklist, "setSubmissionDate", LocalDate.class, LocalDate.parse("2025-06-01"));
        invokeSetter(checklist, "setFields", List.class, List.of(new Field("Emergency Exit", "Available")));
        invokeSetter(checklist, "setOwnerName", String.class, "Updated Alice");
        invokeSetter(checklist, "setOwnerEmail", String.class, "updated_alice@example.com");
        invokeSetter(checklist, "setSubmitterName", String.class, "Updated Bob");
        invokeSetter(checklist, "setSubmitterEmail", String.class, "updated_bob@example.com");
        invokeSetter(checklist, "setAssessorName", String.class, "Updated Charlie");
        invokeSetter(checklist, "setAssessorEmail", String.class, "updated_charlie@example.com");

        // Reflection-based getter assertions
        assertEquals("CHK002", invokeGetter(checklist, "getChecklistId"));
        assertEquals("TEMPLATE002", invokeGetter(checklist, "getChecklistTemplateId"));
        assertEquals("Updated Checklist", invokeGetter(checklist, "getChecklistName"));
        assertEquals(false, invokeGetter(checklist, "isSubmitted"));
        assertEquals(true, invokeGetter(checklist, "isAssessed"));
        assertEquals(LocalDate.parse("2025-06-30"), invokeGetter(checklist, "getDueDate"));
        assertEquals(LocalDate.parse("2025-06-01"), invokeGetter(checklist, "getSubmissionDate"));
        assertEquals(List.of(new Field("Emergency Exit", "Available")), invokeGetter(checklist, "getFields"));
        assertEquals("Updated Alice", invokeGetter(checklist, "getOwnerName"));
        assertEquals("updated_alice@example.com", invokeGetter(checklist, "getOwnerEmail"));
        assertEquals("Updated Bob", invokeGetter(checklist, "getSubmitterName"));
        assertEquals("updated_bob@example.com", invokeGetter(checklist, "getSubmitterEmail"));
        assertEquals("Updated Charlie", invokeGetter(checklist, "getAssessorName"));
        assertEquals("updated_charlie@example.com", invokeGetter(checklist, "getAssessorEmail"));
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
