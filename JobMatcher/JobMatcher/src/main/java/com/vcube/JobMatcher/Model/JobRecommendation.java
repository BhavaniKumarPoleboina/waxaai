package com.vcube.JobMatcher.Model;



import java.util.List;

public class JobRecommendation {

    private Long jobId;
    private String jobTitle;
    private String location;
    private Integer matchPercentage;
    private List<String> matchedSkills;
    private List<String> missingSkills;

    public JobRecommendation() {
    }

    public JobRecommendation(
            Long jobId,
            String jobTitle,
            String location,
            Integer matchPercentage,
            List<String> matchedSkills,
            List<String> missingSkills) {

        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.location = location;
        this.matchPercentage = matchPercentage;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(Integer matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }
}
