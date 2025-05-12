package com.v1.cacs_checklist.controllers;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.TestData;
import com.v1.cacs_checklist.services.ChecklistService;
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

    @GetMapping
    public String home(Model model) {

//        Use this to reseed localhost data
//        List<Checklist> checklists = TestData.getDummyChecklists();
//        checklistService.createChecklists(checklists);

        return "index";
    }

}

