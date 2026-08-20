package com.vcube.JobMatcher.Model;



import java.util.List;

public class SkillGap {

    private Long jobId;
    private String jobTitle;
    private List<String> matchedSkills;
    private List<String> missingSkills;

    public SkillGap() {
    }

    public SkillGap(
            Long jobId,
            String jobTitle,
            List<String> matchedSkills,
            List<String> missingSkills) {

        this.jobId = jobId;
        this.jobTitle = jobTitle;
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