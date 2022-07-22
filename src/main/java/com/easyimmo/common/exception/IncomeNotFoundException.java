package com.easyimmo.common.exception;

public class IncomeNotFoundException extends RuntimeException{

    public IncomeNotFoundException(String message) {
        super("Income not found for id : "+message);
    }
}
