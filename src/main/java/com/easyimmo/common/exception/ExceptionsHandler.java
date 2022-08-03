package com.easyimmo.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<Object>handlePropertyNotFoundException(PropertyNotFoundException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeeNotFoundException.class)
    public ResponseEntity<Object>handleFeeNotFoundException(PropertyNotFoundException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncomeNotFoundException.class)
    public ResponseEntity<Object>handleFeeNotFoundException(IncomeNotFoundException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public ResponseEntity<Object>handleReservationNotFoundException(ReservationNotFoundException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<Object>handleInvalidEntityException(InvalidEntityException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
