package com.easyimmo.common.exception;

public class NotBelongToUserException extends RuntimeException{
    public NotBelongToUserException(String message) {
        super("Requested entity does not belong to user : " + message);
    }
}
