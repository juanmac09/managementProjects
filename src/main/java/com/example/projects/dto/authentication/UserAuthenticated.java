package com.example.projects.dto.authentication;

import com.example.projects.entities.User;

public class UserAuthenticated {
    private User user;

    //Setters and Getters here...

    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        if (this.user == null){
            this.user = user;
        }
    }

}
