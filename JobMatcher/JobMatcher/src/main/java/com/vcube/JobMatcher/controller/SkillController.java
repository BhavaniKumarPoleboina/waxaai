package com.vcube.JobMatcher.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.JobMatcher.Model.Skill;
import com.vcube.JobMatcher.repository.GraphRepository;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {

    private final GraphRepository graphRepository;

    public SkillController(GraphRepository graphRepository) {
        this.graphRepository = graphRepository;
    }

    @GetMapping
    public List<Skill> getSkills() {
        return graphRepository.getSkills();
    }
}
