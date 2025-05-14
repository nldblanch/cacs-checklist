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
@RequestMapping("/assessor")
public class AssessorController {

    @Autowired
    ChecklistService checklistService;

    User user;

    private void verify() {this.user = UserService.getLoggedInUser();}

    private void addNav(Model model) {
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("current", "assessor");
    }

    @GetMapping("/dashboard")
    public String home(Model model) {
        verify();
        addNav(model);

        Map<String, List<Checklist>> categorised = AssessorController.ChecklistCategoriser.filterChecklists(
                checklistService.getAssessorChecklists(user.getUsername())
        );

        List<Checklist> completed = categorised.get("completed");
        List<Checklist> pendingSubmission = categorised.get("pendingSubmission");
        List<Checklist> pendingReview = categorised.get("pendingReview");

        model.addAttribute("completedChecklists", completed);
        model.addAttribute("pendingSubmissionChecklists", pendingSubmission);
        model.addAttribute("pendingReviewChecklists", pendingReview);


//        model.addAttribute("roles", Arrays.asList("owner", "submitter", "admin", "assessor"));
//        model.addAttribute("current", "assessor");
        return "assessor/dashboard";
    }


    static class ChecklistCategoriser {
        public static Map<String, List<Checklist>> filterChecklists(List<Checklist> checklists) {
            List<Checklist> completed = new ArrayList<>();
            List<Checklist> pendingSubmission = new ArrayList<>();
            List<Checklist> pendingReview = new ArrayList<>();

            for (Checklist c : checklists) {
                if (c.isSubmitted() && c.isAssessed()) {
                    //  Submitted AND Assessed → COMPLETED
                    completed.add(c);
                } else if (c.isSubmitted() && !c.isAssessed()) {
                    //  Submitted but NOT Assessed → PENDING SUBMISSION
                    pendingSubmission.add(c);
                } else if (!c.isSubmitted()) {
                    // Not Submitted → PENDING REVIEW (assuming this is what you meant)
                    pendingReview.add(c);
                }
            }

            Map<String, List<Checklist>> result = new HashMap<>();
            result.put("completed", completed);
            result.put("pendingSubmission", pendingSubmission);
            result.put("pendingReview", pendingReview);

            return result;
        }
    }
}

