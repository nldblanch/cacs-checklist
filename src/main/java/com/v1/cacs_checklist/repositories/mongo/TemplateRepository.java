package com.v1.cacs_checklist.repositories;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Field;
import com.v1.cacs_checklist.models.Template;
import com.v1.cacs_checklist.models.Template;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TemplateRepository extends MongoRepository<Template, String> {
    List<Template> findByOwnerEmail(String ownerEmail);

    @Aggregation(pipeline = {
"{ '$match': { 'templateId': ?0 } }",
"{ '$project': { 'fields': 1 } }",
"{ '$unwind': '$fields' }", "{ '$replaceRoot': { 'newRoot': '$fields' } }"
})

List<Field> getFields(String templateID);
}
