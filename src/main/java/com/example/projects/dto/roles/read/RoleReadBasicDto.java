package com.example.projects.dto.roles.read;

public class RoleReadBasicDto {

    private String name;
    private String description;

    //Setters and Getters here...
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
