package com.easyimmo.common.exception;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(String message) {
        super("Reservation not found for : "+message);
    }
}
