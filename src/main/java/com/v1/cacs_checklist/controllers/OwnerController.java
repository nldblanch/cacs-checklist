package com.v1.cacs_checklist.controllers;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Template;
import com.v1.cacs_checklist.models.User;
import com.v1.cacs_checklist.services.ChecklistService;
import com.v1.cacs_checklist.services.TemplateService;
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
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    ChecklistService checklistService;
    @Autowired
    TemplateService templateService;

    User user;

    private void verify() {
        this.user = UserService.getLoggedInUser();
    }

    private void addNav(Model model) {
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("current", "owner");
    }
    @GetMapping("/dashboard")
    public String home(Model model) {
        verify();
        addNav(model);

        Map<String, List<Checklist>> categorised = ChecklistCategoriser.filterChecklists(
                checklistService.getOwnerChecklists(user.getUsername())
        );

        List<Checklist> completed = categorised.get("completed");
        List<Checklist> pending = categorised.get("pending");
        List<Checklist> overdue = categorised.get("overdue");

        model.addAttribute("completedChecklists", completed);
        model.addAttribute("pendingChecklists", pending);
        model.addAttribute("overdueChecklists", overdue);

        return "owner/dashboard";
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

    @GetMapping("/checklists")
    public String getChecklistTemplates(Model model) {
        verify();
        addNav(model);

        List<Template> templates = templateService.getOwnerChecklistTemplates(user.getUsername());
        model.addAttribute("templates", templates);
        return "/owner/checklists";
    }

    @GetMapping("/checklists/{templateId}")
    public String getChecklistTemplateById(@PathVariable String templateId, Model model) {
        verify();
        addNav(model);
        Template template = templateService.getTemplateById(templateId);
        if (template == null) {
            return "redirect:/owner/error";
        }
        model.addAttribute("template", template);
        return "/owner/template-by-id";
    }

    @GetMapping("/checklists/{templateId}/submissions")
    public String getChecklistSubmissions(@PathVariable String templateId, Model model) {
        verify();
        addNav(model);
        Template template = templateService.getTemplateById(templateId);
        if (template == null) {
            return "redirect:/owner/error";
        }
        model.addAttribute("template", template);
        List<Checklist> submissions = checklistService.getChecklistSubmissions(user.getUsername(), templateId);
        model.addAttribute("submissions", submissions);
        return "/owner/checklist-submissions";
    }

    @GetMapping("/checklists/{templateId}/submissions/{submissionId}")
    public String getChecklistById(@PathVariable String templateId, @PathVariable String submissionId, Model model) {
        verify();
        addNav(model);
        Template template = templateService.getTemplateById(templateId);
        Checklist submission = checklistService.getChecklistById(submissionId);

        if (submission == null || tempalte == null) {
            return "redirect:/owner/error";
        }
        model.addAttribute("template", template);
        model.addAttribute("submission", submission);
        return "/owner/submission-by-id";
    }

}

