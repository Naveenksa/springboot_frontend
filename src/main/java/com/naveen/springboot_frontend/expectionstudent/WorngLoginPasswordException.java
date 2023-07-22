package com.naveen.springboot_frontend.expectionstudent;

public class WorngLoginPasswordException extends RuntimeException{

    private String message;


public  WorngLoginPasswordException(String message){
        this.message=message;
    }

    @Override
    public String getMessage(){
    return message;
    }

}
