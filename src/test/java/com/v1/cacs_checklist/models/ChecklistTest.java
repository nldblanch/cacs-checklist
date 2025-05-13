package com.v1.cacs_checklist.models;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChecklistTest {

    @Test
    void testConstructor_setsChecklistId() throws NoSuchFieldException, IllegalAccessException {
        Checklist checklist = new Checklist(
                "CHK001", "Safety Checklist", true, false,
                "2025-05-31", "2025-05-01",
                List.of(new Field("Fire Extinguisher", "Yes")),
                "Alice", "alice@example.com",
                "Bob", "bob@example.com",
                "Charlie", "charlie@example.com"
        );

        final java.lang.reflect.Field field = checklist.getClass().getDeclaredField("checklistId");
        field.setAccessible(true);
        assertEquals("CHK001", field.get(checklist), "Fields didn't match");
    }

    @Test
    void testConstructor_setsChecklistName() throws NoSuchFieldException, IllegalAccessException {
        Checklist checklist = new Checklist(
                "CHK001", "Safety Checklist", true, false,
                "2025-05-31", "2025-05-01",
                List.of(new Field("Fire Extinguisher", "Yes")),
                "Alice", "alice@example.com",
                "Bob", "bob@example.com",
                "Charlie", "charlie@example.com"
        );

        final java.lang.reflect.Field field = checklist.getClass().getDeclaredField("checklistName");
        field.setAccessible(true);
        assertEquals("Safety Checklist", field.get(checklist), "Fields didn't match");
    }

    @Test
    void testConstructor_setsSubmitted() throws NoSuchFieldException, IllegalAccessException {
        Checklist checklist = new Checklist(
                "CHK001", "Safety Checklist", true, false,
                "2025-05-31", "2025-05-01",
                List.of(new Field("Fire Extinguisher", "Yes")),
                "Alice", "alice@example.com",
                "Bob", "bob@example.com",
                "Charlie", "charlie@example.com"
        );

        final java.lang.reflect.Field field = checklist.getClass().getDeclaredField("submitted");
        field.setAccessible(true);
        assertEquals(true, field.get(checklist), "Fields didn't match");
    }

    @Test
    void testConstructor_setsAssessed() throws NoSuchFieldException, IllegalAccessException {
        Checklist checklist = new Checklist(
                "CHK001", "Safety Checklist", true, true,
                "2025-05-31", "2025-05-01",
                List.of(new Field("Fire Extinguisher", "Yes")),
                "Alice", "alice@example.com",
                "Bob", "bob@example.com",
                "Charlie", "charlie@example.com"
        );

        final java.lang.reflect.Field field = checklist.getClass().getDeclaredField("assessed");
        field.setAccessible(true);
        assertEquals(true, field.get(checklist), "Fields didn't match");
    }

    @Test
    void testConstructor_setsFields() throws NoSuchFieldException, IllegalAccessException {
        List<Field> fieldList = List.of(new Field("Fire Extinguisher", "Yes"));
        Checklist checklist = new Checklist(
                "CHK001", "Safety Checklist", true, false,
                "2025-05-31", "2025-05-01",
                fieldList,
                "Alice", "alice@example.com",
                "Bob", "bob@example.com",
                "Charlie", "charlie@example.com"
        );

        final java.lang.reflect.Field field = checklist.getClass().getDeclaredField("fields");
        field.setAccessible(true);
        assertEquals(fieldList, field.get(checklist), "Fields didn't match");
    }

}
