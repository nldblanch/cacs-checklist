package com.v1.cacs_checklist.repositories;

import com.v1.cacs_checklist.models.Checklist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChecklistRepository extends MongoRepository<Checklist, String> {

    @Query("{ 'ownerEmail' : { $regex: ?0, $options: 'i' } }")
    List<Checklist> findByOwnerEmail(String ownerEmail);

    @Query("{ 'submitterEmail' : { $regex: ?0, $options: 'i' } }")
    List<Checklist> findBySubmitterEmail(String ownerEmail);

    @Query("{ 'assessorEmail' : { $regex: ?0, $options: 'i' } }")
    List<Checklist> findByAssessorEmail(String assessorEmail);

    Optional<Checklist> findByChecklistId(String checklistId);

    @Query("{ 'ownerEmail' : { $regex: ?0, $options: 'i' }, 'checklistTemplateId' : ?2 }")
    List<Checklist> findByOwnerEmailAndChecklistTemplateId(String ownerEmail, String checklistTemplateId);

}
