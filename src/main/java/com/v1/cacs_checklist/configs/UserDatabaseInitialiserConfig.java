package com.v1.cacs_checklist.configs;

import com.v1.cacs_checklist.models.User;
import com.v1.cacs_checklist.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration
public class UserDatabaseInitialiserConfig {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initialiseJpaData() {
        return (args)-> {
        };

}

}
