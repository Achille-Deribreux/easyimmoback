package com.easyimmo.common.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({
            InvalidEntityException.class,
            UserAlreadyExistsException.class})
    public ResponseEntity<Object>handleBadRequestException(InvalidEntityException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            UserNotFoundException.class,
            ReservationNotFoundException.class,
            PropertyNotFoundException.class,
            FeeNotFoundException.class,
            IncomeNotFoundException.class,
            BankloanNotFoundException.class
    })
    public ResponseEntity<Object>handleEntityNotFoundException(InvalidEntityException e){
        CustomErrorResponse customErrorResponse = new CustomErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now());
        return new ResponseEntity<>(customErrorResponse,HttpStatus.NOT_FOUND);
    }
}
