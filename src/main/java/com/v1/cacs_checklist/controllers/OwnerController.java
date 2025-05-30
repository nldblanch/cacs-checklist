package com.v1.cacs_checklist.controllers;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Field;
import com.v1.cacs_checklist.models.Template;
import com.v1.cacs_checklist.models.User;
import com.v1.cacs_checklist.services.ChecklistService;
import com.v1.cacs_checklist.services.TemplateService;
import com.v1.cacs_checklist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    ChecklistService checklistService;
    @Autowired
    TemplateService templateService;
    @Autowired
    UserService userService;

    User user;

    private void verify() {
        this.user = UserService.getLoggedInUser();
    }

    private void addNav(Model model) {
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("current", "owner");
        model.addAttribute("username", user.getName());
    }
    @GetMapping("/dashboard")
    public String home(Model model) {
        verify();
        addNav(model);

        Map<String, List<Checklist>> categorised = Checklist.filterChecklists(
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

        if (!Objects.equals(template.getOwnerEmail(), user.getUsername())) {
            return "redirect:/owner/error";
        }

        List<User> submitters = userService.getUsersByRole("SUBMITTER");
        List<User> assessors = userService.getUsersByRole("ASSESSOR");

        model.addAttribute("template", template);
        model.addAttribute("submitters", submitters);
        model.addAttribute("assessors", assessors);
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

        if (submission == null || template == null) {
            return "redirect:/owner/error";
        }
        model.addAttribute("template", template);
        model.addAttribute("submission", submission);
        return "/owner/submission-by-id";
    }

    @PostMapping("/checklists/{templateId}/submit")
    public String submitChecklist(@PathVariable String templateId, @RequestParam String submitter, @RequestParam String assessor, Model model) {
        verify();
        Template template = templateService.getTemplateById(templateId);
        if (template == null) {
            return "redirect:/owner/error";
        }

        String[] submitterInfo = submitter.split("\\|");
        String submitterName = submitterInfo[0];
        String submitterEmail = submitterInfo[1];

        String[] assessorInfo = assessor.split("\\|");
        String assessorName = assessorInfo[0];
        String assessorEmail = assessorInfo[1];

        List<Field> fieldData = templateService.getFields(templateId);

        Checklist newChecklist = new Checklist(
                UUID.randomUUID().toString(),
                templateId,
                template.getTemplateName(),
                false,
                false,
                LocalDate.now().plusDays(7), // Example due date
                null,
                fieldData,//template.getFields(),
                user.getName(), //owner name
                user.getUsername(), //owner email
                submitterName, //submitter name tbc
                submitterEmail, //submitter email tbc
                assessorName, //assessor name tbc
                assessorEmail // assessor email tbc
        );
        checklistService.createChecklist(newChecklist);
        return "redirect:/owner/checklists/" + templateId + "/submissions";
    }

}

