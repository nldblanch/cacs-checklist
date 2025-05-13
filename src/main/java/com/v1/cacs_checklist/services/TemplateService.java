package com.v1.cacs_checklist.services;

import com.v1.cacs_checklist.models.Template;
import com.v1.cacs_checklist.repositories.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
    @Autowired
    private TemplateRepository templateRepository;

    public void createTemplates(List<Template> templates) {
        templateRepository.saveAll(templates);
    }
    public List<Template> getOwnerChecklistTemplates(String username) {
        return templateRepository.findByOwnerEmail(username);
    }

    public Template getTemplateById(String templateId) {
        return templateRepository.findById(templateId).orElse(null);
    }
}
