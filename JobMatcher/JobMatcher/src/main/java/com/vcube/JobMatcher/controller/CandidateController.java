package com.vcube.JobMatcher.controller;






import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.JobMatcher.Model.Candidate;
import com.vcube.JobMatcher.Model.JobRecommendation;
import com.vcube.JobMatcher.Model.Skill;
import com.vcube.JobMatcher.Model.SkillGap;
import com.vcube.JobMatcher.repository.GraphRepository;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    private final GraphRepository graphRepository;

    public CandidateController(GraphRepository graphRepository) {
        this.graphRepository = graphRepository;
    }

    @GetMapping
    public List<Candidate> getCandidates() {
        return graphRepository.getCandidates();
    }

    @GetMapping("/{id}")
    public Candidate getCandidate(@PathVariable Long id) {
        return graphRepository.getCandidateById(id);
    }

    @GetMapping("/{id}/skills")
    public List<Skill> getCandidateSkills(
            @PathVariable Long id) {

        return graphRepository.getCandidateSkills(id);
    }
    
    
    @GetMapping("/{id}/recommendations")
    public List<JobRecommendation> getRecommendations(
            @PathVariable Long id) {

        return graphRepository.getJobRecommendations(id);
    }
    
    @GetMapping("/{id}/skill-gap")
    public List<SkillGap> getSkillGap(
            @PathVariable Long id) {

        return graphRepository.getSkillGaps(id);
    }
}