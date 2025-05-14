package com.v1.cacs_checklist.services;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Field;
import com.v1.cacs_checklist.repositories.ChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<Checklist> getAssessorChecklists(String username) {
        return checklistRepository.findByAssessorEmail(username);
    }

    public Checklist getChecklistById(String checklistId) {
        return checklistRepository.findByChecklistId(checklistId);
    }

    public List<Checklist> getChecklistSubmissions(String username, String templateId) {
        return checklistRepository.findByOwnerEmailAndChecklistTemplateId(username, templateId);
    }

//   public String updateChecklist(String checklistId, List<Field> fields) {
//       Optional<Checklist> checklistOptional = checklistRepository.findById(checklistId);
//
//       if (checklistOptional.isPresent()) {
//
//           Checklist checklist = checklistOptional.get();
//
//           for (Field field: fields) {
//               Optional<Field> checklistField = checklist.getFields().stream()
//                       .filter(f -> f.getFieldName().equals(field.getFieldName()))
//                       .findFirst();
//
//               checklistField.ifPresent(f -> f.setResponse(field.getResponse()));
//           }
//
//           // 3. Save the updated checklist back to the database
//           checklistRepository.save(checklist);
//       }
//     return "updated";
//   }
public String updateChecklist(String checklistId, List<Field> fields) {
    Optional<Checklist> checklistOptional = checklistRepository.findById(checklistId);

    if (checklistOptional.isPresent()) {
        Checklist checklist = checklistOptional.get();

        // Update each field in the checklist with the new response
        for (Field field : fields) {
            Optional<Field> checklistField = checklist.getFields().stream()
                    .filter(f -> f.getFieldName().equals(field.getFieldName()))
                    .findFirst();

            checklistField.ifPresent(f -> f.setResponse(field.getResponse()));
        }

        // Mark the checklist as submitted
        checklist.setSubmitted(true);

        // Save the updated checklist
        checklistRepository.save(checklist);
    }

    return "updated";
}

}
