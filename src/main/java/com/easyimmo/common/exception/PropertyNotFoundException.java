package com.easyimmo.common.exception;

public class PropertyNotFoundException extends RuntimeException{

    public PropertyNotFoundException(String message) {
        super("Property not found for : " + message);
    }
}
