package com.example.projects.common.responses;

public class ApiResponse <T>{

    private boolean success;
    private String message;
    private T data;

    // Setters and Getters here...

    public boolean getSuccess(){
        return this.success;
    }
    public void setSuccess(boolean success){
        this.success = success;
    }

    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }

    public T getData(){
        return this.data;
    }
    public void setData(T data){
        this.data = data;
    }

}
