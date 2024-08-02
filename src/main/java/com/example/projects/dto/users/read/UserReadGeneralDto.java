package com.example.projects.dto.users.read;

import com.example.projects.dto.roles.read.RoleReadBasicDto;

import java.util.List;

public class UserReadGeneralDto {

    private String username;
    private String email;
    private List<RoleReadBasicDto> roles;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleReadBasicDto> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleReadBasicDto> roles) {
        this.roles = roles;
    }
}
