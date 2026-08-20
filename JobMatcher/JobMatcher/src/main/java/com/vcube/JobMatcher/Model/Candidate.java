package com.vcube.JobMatcher.Model;



public class Candidate {

    private Long id;
    private String name;
    private String email;
    private Integer experience;
    private String location;

    public Candidate() {
    }

    public Candidate(Long id, String name, String email,
                      Integer experience, String location) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.experience = experience;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
