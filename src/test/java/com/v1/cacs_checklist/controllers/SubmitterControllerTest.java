package com.v1.cacs_checklist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SubmitterController.class)
class SubmitterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "testUser", roles = {"SUBMITTER"})
    void whenGetDashboard_thenReturnsDashboardViewAndModel() throws Exception {
        mockMvc.perform(get("/submitter/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("submitter/dashboard"))
                .andExpect(model().attribute("current", "submitter"))
                .andExpect(model().attribute("roles",
                        List.of("owner", "submitter", "admin", "assessor")));
    }
}

