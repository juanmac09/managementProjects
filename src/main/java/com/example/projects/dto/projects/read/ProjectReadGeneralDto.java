package com.example.projects.dto.projects.read;


import com.example.projects.dto.users.read.UserReadGeneralDto;

import java.util.Date;

public class ProjectReadGeneralDto {

    private long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private UserReadGeneralDto createdBy;
    private Date createdAt;

    // Setters and Getters here...
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return this.startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UserReadGeneralDto getCreatedBy() {
        return this.createdBy;
    }
    public void setCreatedBy(UserReadGeneralDto createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }




}
