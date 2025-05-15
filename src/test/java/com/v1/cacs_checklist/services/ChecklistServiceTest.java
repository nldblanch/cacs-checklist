package com.v1.cacs_checklist.services;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Field;
import com.v1.cacs_checklist.repositories.mongo.ChecklistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChecklistServiceTest {

    @Mock
    private ChecklistRepository checklistRepository;

    @InjectMocks
    private ChecklistService checklistService;

    @Test
    public void createChecklistTest() {
        Checklist checklist = new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com");

        checklistService.createChecklist(checklist);

        verify(checklistRepository, times(1)).save(checklist);
    }

    @Test
    public void createChecklistsTest() {
        List<Checklist> checklists = List.of(
                new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com")
        );
        checklistService.createChecklists(checklists);

        verify(checklistRepository, times(1)).saveAll(checklists);
    }

    @Test
    public void getOwnerChecklistsTest() {
        String username = "owner1@v1.com";
        List<Checklist> checklists = List.of(
                new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com")
        );

        when(checklistRepository.findByOwnerEmail(username)).thenReturn(checklists);

        List<Checklist> result = checklistService.getOwnerChecklists(username);
        assertEquals(checklists, result);
    }

    @Test
    public void getSubmitterChecklistsTest() {
        String username = "user1@v1.com";
        List<Checklist> checklists = List.of(
                new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com")
        );

        when(checklistRepository.findBySubmitterEmail(username)).thenReturn(checklists);

        List<Checklist> result = checklistService.getSubmitterChecklists(username);
        assertEquals(checklists, result);
    }

    @Test
    public void getAssessorChecklistsTest() {
        String username = "assessor@v1.com";
        List<Checklist> checklists = List.of(
                new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com")
        );

        when(checklistRepository.findByAssessorEmail(username)).thenReturn(checklists);

        List<Checklist> result = checklistService.getAssessorChecklists(username);
        assertEquals(checklists, result);

    }

    @Test
    public void getChecklistByIdTest() {
        String id = "CL001";

        Checklist checklist = new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com");


        when(checklistRepository.findById(id)).thenReturn(Optional.of(checklist));

        Checklist result = checklistService.getChecklistById(id);
        assertEquals(checklist, result);

    }

    @Test
    public void getChecklistSubmissionsTest() {
        String username = "owner1@v1.com";
        String id = "Temp1";
        List<Checklist> checklists = List.of(
                new Checklist("CL001", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Nathan", "user1@v1.com", "Alex", "assessor@v1.com"),

                new Checklist("CL002", "Temp1", "Safety Inspection", true, true, LocalDate.of(2025, 5, 1), LocalDate.of(2025, 5, 2),
                        List.of(new Field("Are fire exits accessible?", "Yes"), new Field("Are emergency lights working?", "No")),
                        "Gurdeep", "owner1@v1.com", "Anees", "user2@v1.com", "Alex", "assessor@v1.com")
        );

        when(checklistRepository.findByOwnerEmailAndChecklistTemplateId(username, id)).thenReturn(checklists);

        List<Checklist> result = checklistService.getChecklistSubmissions(username, id);
        assertEquals(checklists, result);

    }
}
