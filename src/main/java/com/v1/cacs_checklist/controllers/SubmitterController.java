package com.v1.cacs_checklist.controllers;


import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.User;
import com.v1.cacs_checklist.services.ChecklistService;
import com.v1.cacs_checklist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/submitter")
public class SubmitterController {
    @Autowired
    ChecklistService checklistService;


    User user;

    private void verify() {this.user = UserService.getLoggedInUser();}

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
            return "redirect:/submitter/error";  // Adjust to your error page mapping
        }

        // Get the checklist from the Optional
        Checklist checklist = optionalChecklist.get();

        // Add checklist to model so Thymeleaf can access it
        model.addAttribute("checklist", checklist);

        // Check if the checklist is submitted
        if (checklist.isSubmitted()) {
            // If submitted, return the view for the submitted form
            return "submitter/submission-by-id";  // The page that shows submitted checklists
        } else {
            // If not submitted, return the page to complete the checklist
            return "submitter/submission-form";  // A page where user can fill out the form
        }

    }
}


