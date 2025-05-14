package com.v1.cacs_checklist.repositories;

import com.v1.cacs_checklist.models.Checklist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ChecklistRepository extends MongoRepository<Checklist, String> {
    List<Checklist> findByOwnerEmail(String ownerEmail);
    List<Checklist> findBySubmitterEmail(String ownerEmail);
    List<Checklist> findByAssessorEmail(String ownerEmail);
    Checklist findByChecklistId(String checklistId);
    List<Checklist> findByOwnerEmailAndChecklistTemplateId(String ownerEmail, String checklistTemplateId);

}
