package com.v1.cacs_checklist.controllers;

import com.v1.cacs_checklist.models.User;
import org.junit.jupiter.api.*;
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
class SubmitterControllerTest {

    @Autowired
    private MockMvc mvc;
    static User user;

    @BeforeEach
    void setUpSecurityContext() {
        user = new User("user1@v1.com", "password", true, List.of("SUBMITTER"), "Test User");
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()));
    }

    @Test
    void whenGetDashboard_thenReturnsDashboardViewAndModel() throws Exception {
        // Perform request
        MvcResult result = mvc.perform(get("/submitter/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("submitter/dashboard"))
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("completedChecklists", "pendingChecklists", "overdueChecklists", "roles", "current", "username");
        assertThat(modelMap.get("current")).isEqualTo("submitter");
    }

    @Test
    void givenValidIdAndAlreadySubmitted_whenGetChecklistById_thenReturnsChecklist() throws Exception {
        // Perform request
        MvcResult result = mvc.perform(get("/submitter/checklists/CL001"))
                .andExpect(status().isOk())
                .andExpect(view().name("submitter/submission-by-id"))
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("checklist", "roles", "current", "username");
        assertThat(modelMap.get("current")).isEqualTo("submitter");
    }

    @Test
    void givenValidIdAndNotSubmitted_whenGetChecklistById_thenReturnsChecklistToEdit() throws Exception {
        // Perform request
        MvcResult result = mvc.perform(get("/submitter/checklists/CL005"))
                .andExpect(status().isOk())
                .andExpect(view().name("submitter/submission-form"))
                .andReturn();

        // Extract model attributes
        ModelMap modelMap = (ModelMap) Objects.requireNonNull(result.getModelAndView()).getModel();

        // Validate model attributes exist
        assertThat(modelMap).containsKeys("checklist", "roles", "current", "username");
        assertThat(modelMap.get("current")).isEqualTo("submitter");
    }

    @Test
    void givenInvalidId_whenGetChecklistById_thenRedirectsToError() throws Exception {
        // Perform request
        String nonExistentId = "99999";
        mvc.perform(get("/submitter/checklists/{checklistId}", nonExistentId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/submitter/error"));
    }

    @Test
    void givenValidIdBelongsToOtherUser_whenGetChecklistById_thenRedirectsToError() throws Exception {
        // Belongs to user 2, logged in as user 1
        String id = "CL002";

        mvc.perform(get("/submitter/checklists/{checklistId}", id))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/submitter/error"));
    }
}

