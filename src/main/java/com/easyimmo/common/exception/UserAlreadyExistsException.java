package com.easyimmo.common.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message) {
        super("User already exists with username : "+ message);
    }
}
