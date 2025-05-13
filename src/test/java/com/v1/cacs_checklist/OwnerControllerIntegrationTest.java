package com.v1.cacs_checklist;

import com.v1.cacs_checklist.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class OwnerControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void setUpSecurityContext() {
        User ownerUser = new User("owner1@v1.com", "password", true, List.of("OWNER"), "Test User");
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(ownerUser, null, ownerUser.getAuthorities()));
    }

    @Test
    public void givenOwner_whenGetOwnerDashboard_thenStatus200() throws Exception {

        // Perform request
        MvcResult result = mvc.perform(
                        get("/owner/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("owner/dashboard"))
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("completedChecklists", "pendingChecklists", "overdueChecklists", "roles", "current");
        assertThat(modelMap.get("current")).isEqualTo("owner");
    }

    @Test
    public void givenOwner_whenGetChecklistTemplates_thenStatus200() throws Exception {

        // Perform request
        MvcResult result = mvc.perform(
                        get("/owner/checklists"))
                .andExpect(status().isOk())
                .andExpect(view().name("/owner/checklists")) // Verifies view name
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("templates", "roles", "current");

    }

    @Test
    public void givenOwner_whenGetChecklistTemplateById_thenStatus200() throws Exception {

        String templateId = "Temp1";

        // Perform request
        MvcResult result = mvc.perform(
                        get("/owner/checklists/{templateId}", templateId))
                .andExpect(status().isOk())
                .andExpect(view().name("/owner/template-by-id"))
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("template", "roles", "current");

    }

    @Test
    public void givenOwner_whenGetNonExistentChecklistTemplate_thenRedirectsToError() throws Exception {

        String nonExistentTemplateId = "99999";

        mvc.perform(get("/owner/checklists/{templateId}", nonExistentTemplateId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owner/error"));
    }

    @Test
    public void givenOwner_whenGetChecklistSubmissions_thenStatus200() throws Exception {

        String templateId = "Temp1";

        // Perform request
        MvcResult result = mvc.perform(
                        get("/owner/checklists/{templateId}/submissions", templateId))
                .andExpect(status().isOk())
                .andExpect(view().name("/owner/checklist-submissions"))
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("template", "submissions", "roles", "current");

    }

    @Test
    public void givenOwner_whenGetNonExistentChecklistSubmissions_thenRedirectsToError() throws Exception {

        String nonExistentTemplateId = "99999";

        mvc.perform(get("/owner/checklists/{templateId}/submissions", nonExistentTemplateId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owner/error"));
    }

    @Test
    public void givenOwner_whenGetSubmissionById_thenStatus200() throws Exception {

        String templateId = "Temp1";
        String submissionId = "CL001";

        // Perform request
        MvcResult result = mvc.perform(
                        get("/owner/checklists/{templateId}/submissions/{submissionId}", templateId, submissionId))
                .andExpect(status().isOk())
                .andExpect(view().name("/owner/submission-by-id"))
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("submission", "roles", "current");

    }

    @Test
    public void givenOwner_whenGetNonExistentTemplateInSubmissionById_thenRedirectsToError() throws Exception {

        String nonExistentTemplateId = "99999";
        String submissionId = "CL001";
        mvc.perform(get("/owner/checklists/{templateId}/submissions/{submissionId}", nonExistentTemplateId, submissionId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owner/error"));
    }

    @Test
    public void givenOwner_whenGetNonExistentSubmissionId_thenRedirectsToError() throws Exception {

        String templateId = "Temp1";
        String nonExistentSubmissionId = "99999";
        mvc.perform(get("/owner/checklists/{templateId}/submissions/{submissionId}", templateId, nonExistentSubmissionId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owner/error"));
    }

}
