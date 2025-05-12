package com.v1.cacs_checklist.repositories;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Template;
import com.v1.cacs_checklist.models.Template;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TemplateRepository extends MongoRepository<Template, String> {
    List<Template> findByOwnerEmail(String ownerEmail);
}
