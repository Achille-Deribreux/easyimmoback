package com.easyimmo.common.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super("User not found for : " + message);
    }
}