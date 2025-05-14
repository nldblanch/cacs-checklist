package com.v1.cacs_checklist.controllers;


import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Field;
import com.v1.cacs_checklist.models.User;
import com.v1.cacs_checklist.services.ChecklistService;
import com.v1.cacs_checklist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

import static com.v1.cacs_checklist.models.Field.*;

@Controller
@RequestMapping("/submitter")
public class SubmitterController {
    @Autowired
    ChecklistService checklistService;


    User user;

    private void verify() {
        this.user = UserService.getLoggedInUser();
    }

    private void addNav(Model model) {
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("current", "submitter");
        model.addAttribute("username", user.getName());
    }

    @GetMapping("/dashboard")
    public String home(Model model) {
        verify();
        addNav(model);

        Map<String, List<Checklist>> categorised = SubmitterController.ChecklistCategoriser.filterChecklists(
                checklistService.getSubmitterChecklists(user.getUsername())
        );

        List<Checklist> completed = categorised.get("completed");
        List<Checklist> pending = categorised.get("pending");
        List<Checklist> overdue = categorised.get("overdue");

        model.addAttribute("completedChecklists", completed);
        model.addAttribute("pendingChecklists", pending);
        model.addAttribute("overdueChecklists", overdue);
//        model.addAttribute("roles", Arrays.asList("owner", "submitter", "admin", "assessor"));
//        model.addAttribute("current", "submitter");
        return "submitter/dashboard";
    }

    static class ChecklistCategoriser {
        public static Map<String, List<Checklist>> filterChecklists(List<Checklist> checklists) {
            List<Checklist> completed = new ArrayList<>();
            List<Checklist> pending = new ArrayList<>();
            List<Checklist> overdue = new ArrayList<>();

            LocalDate today = LocalDate.now();

            for (Checklist c : checklists) {

                LocalDate dueDate = c.getDueDate();

                if (c.isSubmitted()) {
                    completed.add(c);
                } else if (!c.isSubmitted() && dueDate.isBefore(today)) {
                    overdue.add(c);
                } else if (!c.isSubmitted() && !dueDate.isBefore(today)) {
                    pending.add(c);
                }
            }
            Map<String, List<Checklist>> result = new HashMap<>();
            result.put("completed", completed);
            result.put("pending", pending);
            result.put("overdue", overdue);

            return result;
        }
    }

    @GetMapping("/checklists/{checklistId}")

    public String getChecklistById(@PathVariable String checklistId, Model model) {
        verify();
        addNav(model);
        Optional<Checklist> optionalChecklist = Optional.ofNullable(checklistService.getChecklistById(checklistId));

        // If no checklist is found, redirect to an error page
        if (optionalChecklist.isEmpty()) {
            return "redirect:/submitter/error";
        }

        Checklist checklist = optionalChecklist.get();

        model.addAttribute("checklist", checklist);


        if (checklist.isSubmitted()) {
            // If submitted, return the view for the submitted form
            return "submitter/submission-by-id";
        } else {
            // If not submitted, return the page to complete the checklist
            return "submitter/checklist-edit";
        }

    }

    //    @PostMapping("/checklists/{checklistId}/submit")
//    public String submitChecklist(@PathVariable String checklistId,
//                                  @ModelAttribute("checklist") Checklist checklist) {
//        Checklist existing = checklistService.getChecklistById(checklistId);
//        if (existing == null) {
//            return "redirect:/submitter/error";
//        }
//        List<Field> formFields = checklist.getFields();  // These come from the form data
//        List<Field> existingFields = existing.getFields(); // These are the fields already saved in DB
//
//        for (int i = 0; i < existingFields.size(); i++) {
//            existingFields.get(i).setResponse(formFields.get(i).getResponse());
//        }
//
//        existing.setSubmitted(true);
//        checklistService.saveChecklist(existing);
//
//        return "redirect:/submitter/checklists/" + checklistId;
//    }
//    @PostMapping("/checklists/{checklistId}/submit")
//    public String submitChecklist(@PathVariable String checklistId, @ModelAttribute Checklist checklistFromForm) {
//
//        // Fetch existing checklist from DB using checklistId
//        Checklist existing = checklistService.getChecklistById(checklistId);
//
//        System.out.println(existing);
//
//        // If it doesn't exist, redirect to error page
//        if (existing == null) {
//            return "redirect:/submitter/error";
//        }
//
//        // Update the field responses in the existing checklist using the form values
//        List<Field> submittedFields = checklistFromForm.getFields();
//        List<Field> existingFields = existing.getFields();
//
//        if (submittedFields != null && existingFields != null && submittedFields.size() == existingFields.size()) {
//            for (int i = 0; i < existingFields.size(); i++) {
//                existingFields.get(i).setResponse(submittedFields.get(i).getResponse());
//            }
//        }
//
//        // Mark the checklist as submitted
//        existing.setSubmitted(true);
//        System.out.println(existing.isSubmitted());
//        // Save the updated checklist
//        checklistService.saveChecklist(existing);
//
//        // Redirect to the view page or confirmation
//        return "redirect:/submitter/checklists/" + checklistId;
//    }
    @PostMapping("/submitter/checklists/{checklistId}/submit")
    public String submitChecklist(@PathVariable String checklistId,
                                  @RequestParam Map<String, String> fields) {

        // Fetch the checklist from the database
        Checklist checklist = checklistService.getChecklistById(checklistId);
        if (checklist == null) {
            return "redirect:/submitter/error";  // Handle case where checklist is not found
        }

        // Iterate over the form fields and update the corresponding checklist fields
        for (String fieldName : fields.keySet()) {
            if (fieldName.startsWith("fields[")) {
                String fieldIndex = fieldName.substring(fieldName.indexOf('[') + 1, fieldName.indexOf(']'));
                String response = fields.get(fieldName);

                // Find the corresponding field in the checklist
                int index = Integer.parseInt(fieldIndex);
                Field field = checklist.getFields().get(index);
                field.setResponse(response);
            }
        }

        // Mark the checklist as submitted
        checklist.setSubmitted(true);

        // Save the updated checklist
        checklistService.updateChecklist(checklistId, checklist.getFields());

        // Redirect to the checklist detail page after submission
        return "redirect:/submitter/checklists/" + checklistId;
    }

}




