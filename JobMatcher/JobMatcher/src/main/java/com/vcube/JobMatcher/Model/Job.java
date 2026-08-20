package com.vcube.JobMatcher.Model;


public class Job {

    private Long id;
    private String title;
    private String location;
    private Integer experienceRequired;
    private Long salary;
    private String jobType;

    public Job() {
    }

    public Job(Long id, String title, String location,
               Integer experienceRequired, Long salary,
               String jobType) {

        this.id = id;
        this.title = title;
        this.location = location;
        this.experienceRequired = experienceRequired;
        this.salary = salary;
        this.jobType = jobType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getExperienceRequired() {
        return experienceRequired;
    }

    public void setExperienceRequired(Integer experienceRequired) {
        this.experienceRequired = experienceRequired;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }
}
