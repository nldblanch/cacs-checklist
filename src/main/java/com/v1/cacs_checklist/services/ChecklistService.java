package com.v1.cacs_checklist.services;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.repositories.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChecklistService
{
    @Autowired
    private ChecklistRepository checklistRepository;

    public void createChecklist(Checklist checklist) {
        checklistRepository.save(checklist);
    }

    public void createChecklists(List<Checklist> checklists) {
        checklistRepository.saveAll(checklists);
    }

    public List<Checklist> getOwnerChecklists(String username) {
        return checklistRepository.findByOwnerEmail(username);
    }
    public List<Checklist> getSubmitterChecklists(String username) {
        return checklistRepository.findBySubmitterEmail(username);
    }

    public Checklist getChecklistById(String checklistId) {
        return checklistRepository.findById(checklistId).orElse(null);
    }

    public List<Checklist> getChecklistSubmissions(String username, String templateId) {
        return checklistRepository.findByOwnerEmailAndChecklistTemplateId(username, templateId);
    }
}
