package com.vcube.JobMatcher.Model;


public class Course {

    private Long id;
    private String name;
    private String platform;
    private String url;

    public Course() {
    }

    public Course(Long id, String name,
                  String platform, String url) {

        this.id = id;
        this.name = name;
        this.platform = platform;
        this.url = url;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}