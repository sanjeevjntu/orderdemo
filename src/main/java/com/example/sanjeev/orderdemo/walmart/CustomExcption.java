package com.example.sanjeev.orderdemo.walmart;

public class CustomExcption extends Exception {

    public CustomExcption(){

    }
    public CustomExcption(String errorMessage){
        super(errorMessage);
    }

    public CustomExcption(String message, Throwable cause) {
        super(message, cause);
    }

}
