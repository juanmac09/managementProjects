package com.example.projects.dto.users.write;

import java.util.List;

public class UserCreateDto {

    private String username;
    private String email;
    private List<Long> roles;

    //Setters and Getters here...
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Long> getRoles() {
        return this.roles;
    }
    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }
}
