package com.v1.cacs_checklist.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.Customizer; // Correct import
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/").permitAll()

                        //Admin permissions
                        .requestMatchers("/admin/dashboard").hasAuthority("ADMIN")
                        .requestMatchers("/admin/assign").hasAuthority("ADMIN")
                        .requestMatchers("/admin/projects").hasAuthority("ADMIN")
                        //Submitter permissions
                        .requestMatchers("/submitter/dashboard").hasAuthority("SUBMITTER")
                        .requestMatchers("/submitter/checklists").hasAuthority("SUBMITTER")
                        .requestMatchers("/submitter/checklists/{id}").hasAuthority("SUBMITTER")
                        .requestMatchers("/submitter/checklists/pending").hasAuthority("SUBMITTER")
                        .requestMatchers("/submitter/checklists/pending/{id}").hasAuthority("SUBMITTER")
                        //Assessor permissions
                        .requestMatchers("/assessor/dashboard").hasAuthority("ASSESSOR")
                        .requestMatchers("/assessor/checklists").hasAuthority("ASSESSOR")
                        .requestMatchers("/assessor/checklists/{id}").hasAuthority("ASSESSOR")
                        .requestMatchers("/assessor/checklists/pending").hasAuthority("ASSESSOR")
                        .requestMatchers("/assessor/checklists/pending/{id}").hasAuthority("ASSESSOR")
                        //Owner permissions
                        .requestMatchers("/owner/dashboard").hasAuthority("OWNER")
                        .requestMatchers("/owner/checklists").hasAuthority("OWNER")
                        .requestMatchers("/owner/checklists/{templateId}").hasAuthority("OWNER")
                        .requestMatchers("/owner/checklists/{templateId}/submissions").hasAuthority("OWNER")
                        .requestMatchers("/owner/checklists/{templateId}/submissions/{submissionId}").hasAuthority("ASSESSOR")
                        // Other permissions
                        .requestMatchers("/**").denyAll()
                        .requestMatchers("/login.html").permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());

        return http.build();

    }
}
