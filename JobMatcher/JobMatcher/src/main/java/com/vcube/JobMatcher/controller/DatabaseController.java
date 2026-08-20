package com.vcube.JobMatcher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.JobMatcher.repository.DatabaseRepository;

@RestController
public class DatabaseController {

    private final DatabaseRepository databaseRepository;

    public DatabaseController(DatabaseRepository databaseRepository) {
        this.databaseRepository = databaseRepository;
    }

    @GetMapping("/api/health/database")
    public String testDatabase() {

        return databaseRepository.testConnection();
    }
}
