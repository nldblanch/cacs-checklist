package com.v1.cacs_checklist.controllers;

import com.v1.cacs_checklist.models.Checklist;
import com.v1.cacs_checklist.models.TestData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/owner")
public class OwnerController {

    @GetMapping("/dashboard")
    public String home(Model model) {
        Map<String, List<Checklist>> categorised = ChecklistCategoriser.filterChecklists(
                TestData.getDummyChecklists(), "dave@company.com"
        );

        List<Checklist> completed = categorised.get("completed");
        List<Checklist> pending = categorised.get("pending");
        List<Checklist> overdue = categorised.get("overdue");

        model.addAttribute("completedChecklists", completed);
        model.addAttribute("pendingChecklists", pending);
        model.addAttribute("overdueChecklists", overdue);

        model.addAttribute("roles", Arrays.asList("owner", "submitter", "admin", "assessor"));
        model.addAttribute("current", "owner");
        return "owner/dashboard";
    }

    static class ChecklistCategoriser {
        public static Map<String, List<Checklist>> filterChecklists(List<Checklist> checklists, String identifier) {
            List<Checklist> completed = new ArrayList<>();
            List<Checklist> pending = new ArrayList<>();
            List<Checklist> overdue = new ArrayList<>();

            LocalDate today = LocalDate.now();

            for (Checklist c : checklists) {
                if (!c.getOwnerEmail().equalsIgnoreCase(identifier)) continue;

                LocalDate dueDate = LocalDate.parse(c.getDueDate());

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
}

