package com.vcube.JobMatcher.controller;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.JobMatcher.Model.Job;
import com.vcube.JobMatcher.Model.Skill;
import com.vcube.JobMatcher.repository.GraphRepository;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "http://localhost:4200")
public class JobController {

    private final GraphRepository graphRepository;

    public JobController(GraphRepository graphRepository) {
        this.graphRepository = graphRepository;
    }

    @GetMapping
    public List<Job> getJobs() {
        return graphRepository.getJobs();
    }

    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id) {
        return graphRepository.getJobById(id);
    }

    @GetMapping("/{id}/skills")
    public List<Skill> getJobSkills(
            @PathVariable Long id) {

        return graphRepository.getJobSkills(id);
    }
}