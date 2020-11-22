package com.example.ian.baypeoples.exception;

public class UserNotFoundException extends Exception {
    private String message;

    public UserNotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
