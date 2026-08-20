package com.vcube.JobMatcher.controller;



import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.JobMatcher.Model.Course;
import com.vcube.JobMatcher.repository.GraphRepository;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {

    private final GraphRepository graphRepository;

    public CourseController(GraphRepository graphRepository) {
        this.graphRepository = graphRepository;
    }

    @GetMapping("/{id}/courses")
    public List<Course> getRecommendedCourses(
            @PathVariable Long id) {

        return graphRepository
                .getCoursesForMissingSkills(id);
    }
}
