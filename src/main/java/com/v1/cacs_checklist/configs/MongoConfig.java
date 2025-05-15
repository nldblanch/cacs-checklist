package com.v1.cacs_checklist.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.v1.cacs_checklist.repositories.mongo")
public class MongoConfig {
}

