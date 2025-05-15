package com.v1.cacs_checklist.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.v1.cacs_checklist.repositories.jpa")
public class JpaConfig {
}
