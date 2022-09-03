package com.easyimmo.common.exception;

public class BankloanNotFoundException extends RuntimeException{

    public BankloanNotFoundException(String message) {
        super("Bankloan not found for = "+message);
    }
}
