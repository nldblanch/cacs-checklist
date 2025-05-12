package com.v1.cacs_checklist.controllers;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.Template;
import com.v1.cacs_checklist.models.TestChecklistData;
import com.v1.cacs_checklist.services.ChecklistService;
import com.v1.cacs_checklist.services.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ChecklistService checklistService;
    @Autowired
    TemplateService templateService;

    @GetMapping
    public String home(Model model) {

//        Use this to reseed localhost data
        List<Checklist> checklists = TestChecklistData.getDummyChecklists();
        checklistService.createChecklists(checklists);

        List<Template> templates = TestChecklistData.getDummyTemplates();
        templateService.createTemplates(templates);

        return "index";
    }

}

