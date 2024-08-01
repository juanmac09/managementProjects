package com.example.projects.dtos.authentication;


public class RegisterUserDto {
    private String username;
    private String password;
    private String email;


    // getters and setters here...

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }


    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }


}

