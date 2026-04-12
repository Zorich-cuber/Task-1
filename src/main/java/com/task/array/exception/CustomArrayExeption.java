package com.task.array.exception;

public class CustomArrayExeption extends RuntimeException {
    public CustomArrayExeption(String message){
        super(message);
    }
    public CustomArrayExeption(String message, Throwable cause) {
        super(message, cause);
    }
}

