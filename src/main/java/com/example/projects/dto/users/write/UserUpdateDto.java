package com.example.projects.dto.users.write;


public class UserUpdateDto {

    private String password;
    private String confirmPassword;

    //Setters and Getters here...
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getConfirmPassword() {
        return this.confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean equals() {
        return password.equals(confirmPassword);
    }
}
