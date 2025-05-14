package com.v1.cacs_checklist.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.Customizer; // Correct import
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Autowired
    private CustomAuthSuccessHandler customAuthSuccessHandler;


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/", "/login.html").permitAll()

                        //Admin permissions
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        //Submitter permissions
                        .requestMatchers("/submitter/**").hasAuthority("SUBMITTER")
                        //Assessor permissions
                        .requestMatchers("/assessor/**").hasAuthority("ASSESSOR")
                        //Owner permissions
                        .requestMatchers("/owner/**").hasAuthority("OWNER")
                        // Other permissions
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(customAuthSuccessHandler)
                        .failureUrl("/login-error")
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/")
                        .permitAll()
                )
                .sessionManagement(session -> session
                        .sessionFixation().newSession()
                        .invalidSessionUrl("/login?sessionExpired")
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();

    }
}
