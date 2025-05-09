package com.v1.cacs_checklist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;


@Controller
@RequestMapping("/assessor")
public class AssessorController {

    @GetMapping("/dashboard")
    public String home(Model model) {
        model.addAttribute("roles", Arrays.asList("owner", "submitter", "admin", "assessor"));
        model.addAttribute("current", "assessor");
        return "assessor/dashboard";
    }

}

