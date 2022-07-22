package com.easyimmo.common.exception;

public class FeeNotFoundException extends RuntimeException{

    public FeeNotFoundException(String message) {
        super("Fee not found for : "+message);
    }
}
