package com.v1.cacs_checklist.repositories;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Field;
import com.v1.cacs_checklist.models.Template;
import com.v1.cacs_checklist.models.TestChecklistData;
import com.v1.cacs_checklist.repositories.mongo.ChecklistRepository;
import com.v1.cacs_checklist.services.ChecklistService;
import com.v1.cacs_checklist.services.TemplateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChecklistRepositoryIntegrationTests {
    @Autowired
    private ChecklistRepository checklistRepository;

    @Autowired
    ChecklistService checklistService;
    @Autowired
    TemplateService templateService;

    @BeforeEach
    public void refreshData() {
        List<Checklist> checklists = TestChecklistData.getDummyChecklists();
        checklistService.createChecklists(checklists);

        List<Template> templates = TestChecklistData.getDummyTemplates();
        templateService.createTemplates(templates);
    }

    @Test
    public void testFindByOwnerEmail() {

        // Given
        Checklist checklist1 = new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Test", "test@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com");

        Checklist checklist2 = new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Test", "test@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com");

        checklistRepository.saveAll(List.of(checklist1, checklist2));

        // When
        List<Checklist> result = checklistRepository.findByOwnerEmail("test@v1.com");

        // Then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        result.forEach(el -> assertEquals("test@v1.com", el.getOwnerEmail()));

    }

    @Test
    public void testFindByOwnerEmail_whenCaseInsensitive() {
        // Given
        Checklist checklist1 = new Checklist("CL45894", "", "", true, true, null, null,
                List.of(new Field("", "")),
                "owner-45894", "owner-45894@v1.com", "", "", "", "");

        Checklist checklist2 = new Checklist("CL45895", "", "", true, true, null, null,
                List.of(new Field("", "")),
                "owner-45894", "owner-45894@v1.com", "", "", "", "");

        checklistRepository.saveAll(List.of(checklist1, checklist2));

        // When
        List<Checklist> result = checklistRepository.findByOwnerEmail("OwNER-45894@v1.com");

        // Then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        result.forEach(el -> assertEquals("owner-45894@v1.com", el.getOwnerEmail()));

    }

    @Test
    public void testFindBySubmitterEmail() {

        // given
        Checklist checklist1 = new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Test", "test@v1.com", "Nathan", "testuser1@v1.com", "Alex", "assessor@v1.com");

        Checklist checklist2 = new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Test", "test@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com");

        checklistRepository.saveAll(List.of(checklist1, checklist2));

        // when
        List<Checklist> result = checklistRepository.findBySubmitterEmail("testuser1@v1.com");

        // then
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        result.forEach(el ->
                assertEquals("testuser1@v1.com", el.getSubmitterEmail())
        );

    }

    @Test
    public void testFindBySubmitterEmail_whenCaseInsensitive() {
        // Given
        Checklist checklist1 = new Checklist("CL45896", "", "", true, true, null, null,
                List.of(new Field("", "")),
                "", "", "test", "sub-45894@v1.com", "", "");

        Checklist checklist2 = new Checklist("CL45897", "", "", true, true, null, null,
                List.of(new Field("", "")),
                "", "", "test", "sub-45894@v1.com", "", "");

        checklistRepository.saveAll(List.of(checklist1, checklist2));

        // When
        List<Checklist> result = checklistRepository.findBySubmitterEmail("SUB-45894@v1.com");

        // Then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        result.forEach(el -> assertEquals("sub-45894@v1.com", el.getSubmitterEmail()));

    }
    //test for not matching records


    @Test
    public void testFindByAssessorEmail() {
        // Given
        Checklist checklist1 = new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Test", "test@v1.com", "Nathan", "user1@v1.com", "Alex", "test-assessor1@v1.com");

        Checklist checklist2 = new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Test", "test@v1.com", "Anees", "user2@v1.com", "Alex", "test-assessor1@v1.com");
        Checklist checklist3 = new Checklist("CL003", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Test", "test@v1.com", "Hibbah", "user3@v1.com", "Alan", "not-assessor@v1.com");

        checklistRepository.saveAll(List.of(checklist1, checklist2, checklist3));

        // When
        List<Checklist> result = checklistRepository.findByAssessorEmail("test-assessor1@v1.com");

        // Then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        result.forEach(el -> assertEquals("test-assessor1@v1.com", el.getAssessorEmail()));

    }

    @Test
    public void testFindByAssessorEmail_whenCaseInsensitive() {
        // Given
        Checklist checklist1 = new Checklist("CL45898", "", "", true, true, null, null,
                List.of(new Field("", "")),
                "", "", "", "", "", "assess-45894@v1.com");

        Checklist checklist2 = new Checklist("CL45899", "", "", true, true, null, null,
                List.of(new Field("", "")),
                "", "", "", "", "", "assess-45894@v1.com");

        checklistRepository.saveAll(List.of(checklist1, checklist2));

        // When
        List<Checklist> result = checklistRepository.findByAssessorEmail("ASSESS-45894@v1.com");

        // Then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        result.forEach(el -> assertEquals("assess-45894@v1.com", el.getAssessorEmail()));

    }

    @Test
    public void testFindByChecklistId_whenGivenId() {
        // Given
        Checklist checklist1 = new Checklist("C100", "T1", "Template name", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Question 1", "Yes"), new Field("Question 2", "No")),
                "Test Owner", "test-owner@v1.com", "Test User", "test-user@v1.com", "Test Assessor", "test-assessor@v1.com");

        checklistRepository.save(checklist1);

        // When
        Optional<Checklist> result = checklistRepository.findByChecklistId("C100");

        // Then
        assertFalse(result.isEmpty());
        assertEquals("C100", result.get().getChecklistId());
    }

    @Test
    public void testFindByChecklistId_whenGivenInvalidId() {
        // Given
        String checklistId = "not-an-id-that-exists";

        // When
        Optional<Checklist> result = checklistRepository.findByChecklistId(checklistId);

        // Then
        assertTrue(result.isEmpty());
    }

    //test for invalid id formats

    @Test
    public void testFindByOwnerEmailAndChecklistTemplateId() {
        // Given
        Checklist checklist1 = new Checklist("CL101", "Temp100", null, false, false, null, null,
                List.of(new Field(null, ""), new Field(null, "")),
                "owner-25", "owner-25@v1.com", null, null, "", "");

        Checklist checklist2 = new Checklist("CL102", "Temp100", null, false, false, null, null,
                List.of(new Field(null, ""), new Field("", "")),
                "owner-26", "onwer-26@v1.com", null, null, "", "");

        Checklist checklist3 = new Checklist("CL103", "Temp100", null, false, false, null, null,
                List.of(new Field(null, ""), new Field(null, "")),
                "owner-25", "owner-25@v1.com", null, null, "", "");

        Checklist checklist4 = new Checklist("CL104", "Temp101", null, false, false, null, null,
                List.of(new Field(null, ""), new Field(null, "")),
                "owner-25", "onwer-25@v1.com", null, null, "", "");

        checklistRepository.saveAll(List.of(checklist1, checklist2, checklist3, checklist4));

        // When
        List<Checklist> result = checklistRepository.findByOwnerEmailAndChecklistTemplateId("owner-25@v1.com", "Temp100");

        // Then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        result.forEach(el -> {
            assertEquals("owner-25@v1.com", el.getOwnerEmail());
            assertEquals("Temp100", el.getChecklistTemplateId());
        });
    }

    @Test
    public void testFindByOwnerEmailAndChecklistTemplateId_whenCaseInsensitive() {
        // Given
        Checklist checklist1 = new Checklist("CL1011", "Temp1001", null, false, false, null, null,
                List.of(new Field(null, ""), new Field(null, "")),
                "owner-251", "owner-251@v1.com", null, null, "", "");

        Checklist checklist2 = new Checklist("CL1021", "Temp1001", null, false, false, null, null,
                List.of(new Field(null, ""), new Field("", "")),
                "owner-261", "owner-261@v1.com", null, null, "", "");

        Checklist checklist3 = new Checklist("CL1031", "Temp1001", null, false, false, null, null,
                List.of(new Field(null, ""), new Field(null, "")),
                "owner-251", "owner-251@v1.com", null, null, "", "");

        Checklist checklist4 = new Checklist("CL1041", "Temp1011", null, false, false, null, null,
                List.of(new Field(null, ""), new Field(null, "")),
                "owner-251", "owner-251@v1.com", null, null, "", "");

        checklistRepository.saveAll(List.of(checklist1, checklist2, checklist3, checklist4));
        // When
        List<Checklist> result = checklistRepository.findByOwnerEmailAndChecklistTemplateId("owner-251@v1.com", "Temp1001");

        // Then
        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
        result.forEach(el -> {
            assertEquals("owner-251@v1.com", el.getOwnerEmail());
            assertEquals("Temp1001", el.getChecklistTemplateId());
        });
    }


}

