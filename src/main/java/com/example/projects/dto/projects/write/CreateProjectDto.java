package com.example.projects.dto.projects.write;

import com.example.projects.dto.authentication.UserAuthenticated;
import com.example.projects.entities.User;

import java.util.Date;

public class CreateProjectDto {
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private User createdBy = null;

    //Setters and Getters

    public String getTitle(){
        return this.title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Date getStartDate(){
        return this.startDate;
    }
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    public Date getEndDate(){
        return this.endDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    public User getCreatedBy(){
        return this.createdBy;
    }
    public void setCreatedBy(User createdBy){
        this.createdBy = createdBy;
    }

}
