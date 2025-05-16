package com.v1.cacs_checklist.models;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

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
        Checklist checklist = new Checklist("CHK001", "TEMPLATE001", "Safety Checklist", true, false, LocalDate.parse("2025-05-31"), LocalDate.parse("2025-05-01"), List.of(new Field("Fire Extinguisher", "Yes")), "Alice", "alice@example.com", "Bob", "bob@example.com", "Charlie", "charlie@example.com");

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

    @Test
    void testFilterChecklists() {
        // Arrange: define "today" so that test cases are deterministic.
        LocalDate today = LocalDate.now();

        // Checklist1 is submitted so it must appear in "completed"
        Checklist checklist1 = new Checklist("1", "1", "", true, false, today, today.minusDays(1), List.of(new Field("", "")), "", "", "", "", "", "");

        // Checklist2 is not submitted and its due date is in the past => overdue.
        Checklist checklist2 = new Checklist("2", "1", "", false, false, today.minusDays(1), null, List.of(new Field("", "")), "", "", "", "", "", "");

        // Checklist3 is not submitted and its due date is today => pending.
        Checklist checklist3 = new Checklist("3", "1", "", false, false, today, null, List.of(new Field("", "")), "", "", "", "", "", "");

        // Checklist4 is not submitted and its due date is in the future => pending.
        Checklist checklist4 = new Checklist("4", "1", "", false, false, today.plusDays(1), null, List.of(new Field("", "")), "", "", "", "", "", "");


        List<Checklist> checklists = List.of(checklist1, checklist2, checklist3, checklist4);

        // Act: filter the checklists.
        Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);

        // Assert: verify that the returned map correctly categorizes items.
        List<Checklist> completed = result.get("completed");
        List<Checklist> overdue = result.get("overdue");
        List<Checklist> pending = result.get("pending");

        // Ensure the lists are not null.
        assertNotNull(completed);
        assertNotNull(overdue);
        assertNotNull(pending);

        // Check that there is exactly one completed checklist.
        assertEquals(1, completed.size(), "There should be 1 completed checklist");
        assertEquals("1", completed.getFirst().getChecklistId(), "Checklist 1 should be completed");

        // There should be one checklist overdue.
        assertEquals(1, overdue.size(), "There should be 1 overdue checklist");
        assertEquals("2", overdue.getFirst().getChecklistId(), "Checklist 2 should be overdue");

        // There should be two pending checklists.
        assertEquals(2, pending.size(), "There should be 2 pending checklists");
        List<String> pendingIds = pending.stream().map(Checklist::getChecklistId).toList();
        assertTrue(pendingIds.contains("3"), "Checklist 3 should be pending");
        assertTrue(pendingIds.contains("4"), "Checklist 4 should be pending");
    }

    // edge cases
    @Test
    void givenEmptyList_whenFilterChecklists_thenEmptyMapReturned() {
        Map<String, List<Checklist>> result = Checklist.filterChecklists(List.of());

        // Assert: verify that the returned map correctly categorizes items.
        assertNotNull(result);
        assertTrue(result.get("completed").isEmpty(), "Completed list should be empty");
        assertTrue(result.get("overdue").isEmpty(), "Overdue list should be empty");
        assertTrue(result.get("pending").isEmpty(), "Pending list should be empty");
    }

    @Test
    void givenNullInput_whenFilterChecklists_thenThrowsException() {
        assertThrows(NullPointerException.class, () -> Checklist.filterChecklists(null));
    }

    @Test
    void givenChecklistWithNullDueDate_whenFilterChecklists_thenHandledGracefully() {
        // Arrange: define "today" so that your test cases are deterministic.
        LocalDate today = LocalDate.now();

        // Null due date
        Checklist checklist1 = new Checklist("1", "1", "", false, false, null, null, List.of(new Field("", "")), "", "", "", "", "", "");

        // Normal case
        Checklist checklist2 = new Checklist("2", "1", "", false, false, today, null, List.of(new Field("", "")), "", "", "", "", "", "");

        List<Checklist> checklists = List.of(checklist1, checklist2);

        assertDoesNotThrow(() -> {
            Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);
            assertNotNull(result);

            assertTrue(result.get("pending").contains(checklist1), "Checklist with null due date should be pending");
        });
    }

    @Test
    void givenSubmittedChecklistWithPastDueDate_whenFilterChecklists_thenCategorizedAsCompleted() {
        // Arrange: define "today" so that your test cases are deterministic.
        LocalDate today = LocalDate.now();

        // Past due date, completed today
        Checklist checklist1 = new Checklist("1", "1", "", true, false, today.minusDays(1), today, List.of(new Field("", "")), "", "", "", "", "", "");

        // Normal case - completed today, due tomorrow
        Checklist checklist2 = new Checklist("2", "1", "", true, false, today, today.plusDays(1), List.of(new Field("", "")), "", "", "", "", "", "");

        List<Checklist> checklists = List.of(checklist1, checklist2);

        Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);
        assertNotNull(result);
        List<Checklist> completed = result.get("completed");
        assertEquals(2, completed.size(), "There should be 1 completed checklist");
        assertTrue(completed.contains(checklist1), "Checklist with null due date should be pending");

    }

    @Test
    void givenChecklistDueToday_whenFilterChecklists_thenCategorizedAsPending() {
        // Arrange: define "today" so the test is deterministic
        LocalDate today = LocalDate.now();
        Checklist checklist1 = new Checklist("1", "1", "", false, false, today, null, List.of(new Field("", "")), "", "", "", "", "", ""); // Due date = today, not submitted

        List<Checklist> checklists = List.of(checklist1);

        // Act: filter checklists
        Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);

        // Assert: ensure correct categorization
        assertNotNull(result);
        assertTrue(result.get("pending").contains(checklist1), "Checklist due today should be pending");
        assertFalse(result.get("overdue").contains(checklist1), "Checklist due today should not be overdue");
        assertFalse(result.get("completed").contains(checklist1), "Checklist due today should not be completed");

    }

    @Test
    void givenAllSubmittedChecklists_whenFilterChecklists_thenNoPendingOrOverdue() {
        // Arrange: define "today" for deterministic testing
        LocalDate today = LocalDate.now();

        // All checklists are submitted, regardless of due date
        Checklist checklist1 = new Checklist("1", "1", "", true, false, today.minusDays(5), today, List.of(new Field("", "")), "", "", "", "", "", "");
        Checklist checklist2 = new Checklist("2", "2", "", true, false, today, today, List.of(new Field("", "")), "", "", "", "", "", "");
        Checklist checklist3 = new Checklist("3", "3", "", true, false, today.plusDays(5), today, List.of(new Field("", "")), "", "", "", "", "", "");

        List<Checklist> checklists = List.of(checklist1, checklist2, checklist3);

        // Act: filter checklists
        Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);

        // Assert: ensure correct categorization
        assertNotNull(result);
        assertTrue(result.get("completed").containsAll(checklists), "All checklists should be categorized as completed");
        assertTrue(result.get("pending").isEmpty(), "No checklists should be pending");
        assertTrue(result.get("overdue").isEmpty(), "No checklists should be overdue");
    }

    @Test
    void givenAllOverdueChecklists_whenFilterChecklists_thenNoPendingOrCompleted() {
        // Arrange: define "today" for deterministic testing
        LocalDate today = LocalDate.now();

        // All checklists are NOT submitted and their due dates are in the past
        Checklist checklist1 = new Checklist("1", "1", "", false, false, today.minusDays(5), null, List.of(new Field("", "")), "", "", "", "", "", "");
        Checklist checklist2 = new Checklist("2", "2", "", false, false, today.minusDays(10), null, List.of(new Field("", "")), "", "", "", "", "", "");
        Checklist checklist3 = new Checklist("3", "3", "", false, false, today.minusDays(20), null, List.of(new Field("", "")), "", "", "", "", "", "");

        List<Checklist> checklists = List.of(checklist1, checklist2, checklist3);

        // Act: filter checklists
        Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);

        // Assert: ensure correct categorization
        assertNotNull(result);
        assertTrue(result.get("overdue").containsAll(checklists), "All checklists should be categorized as overdue");
        assertTrue(result.get("pending").isEmpty(), "No checklists should be pending");
        assertTrue(result.get("completed").isEmpty(), "No checklists should be completed");
    }

    @Test
    void givenAllPendingChecklists_whenFilterChecklists_thenNoOverdueOrCompleted() {
        // Arrange: define "today" for deterministic testing
        LocalDate today = LocalDate.now();

        // All checklists are NOT submitted and their due dates are today or in the future
        Checklist checklist1 = new Checklist("1", "1", "", false, false, today, null, List.of(new Field("", "")), "", "", "", "", "", "");
        Checklist checklist2 = new Checklist("2", "2", "", false, false, today.plusDays(5), null, List.of(new Field("", "")), "", "", "", "", "", "");
        Checklist checklist3 = new Checklist("3", "3", "", false, false, today.plusDays(10), null, List.of(new Field("", "")), "", "", "", "", "", "");

        List<Checklist> checklists = List.of(checklist1, checklist2, checklist3);

        // Act: filter checklists
        Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);

        // Assert: ensure correct categorization
        assertNotNull(result);
        assertTrue(result.get("pending").containsAll(checklists), "All checklists should be categorized as pending");
        assertTrue(result.get("completed").isEmpty(), "No checklists should be completed");
        assertTrue(result.get("overdue").isEmpty(), "No checklists should be overdue");
    }

    @Test
    void givenChecklistWithFarFutureDueDate_whenFilterChecklists_thenCategorizedAsPending() {
        // Arrange: define "today" for deterministic testing
        LocalDate today = LocalDate.now();
        LocalDate farFutureDate = today.plusYears(5); // Checklist due in 5 years

        // Checklist is NOT submitted and due far in the future
        Checklist checklist1 = new Checklist("1", "1", "", false, false, farFutureDate, null,
                List.of(new Field("", "")), "", "", "", "", "", "");

        List<Checklist> checklists = List.of(checklist1);

        // Act: filter checklists
        Map<String, List<Checklist>> result = Checklist.filterChecklists(checklists);

        // Assert: ensure correct categorization
        assertNotNull(result);
        assertTrue(result.get("pending").contains(checklist1), "Checklist with far future due date should be pending");
        assertTrue(result.get("completed").isEmpty(), "No checklists should be completed");
        assertTrue(result.get("overdue").isEmpty(), "No checklists should be overdue");
    }


}
