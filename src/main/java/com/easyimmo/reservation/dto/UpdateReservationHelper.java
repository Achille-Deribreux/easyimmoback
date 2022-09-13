package com.easyimmo.reservation.dto;

import java.time.LocalDate;
import java.util.List;

import com.easyimmo.fees.model.Fee;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.model.Property;
import com.easyimmo.reservation.model.Reservation;

public class UpdateReservationHelper {

    private Reservation reservation;

    public UpdateReservationHelper(Reservation reservation) {
        this.reservation = reservation;
    }

    public static UpdateReservationHelper of(Reservation reservation) {
        return new UpdateReservationHelper(reservation);
    }

    public UpdateReservationHelper reservationDate(LocalDate reservationDate) {
        if (reservationDate != null && reservationDate != reservation.getReservationDate()) {
            reservation.setReservationDate(reservationDate);
        }
        return this;
    }

    public UpdateReservationHelper fromDate(LocalDate fromDate) {
        if(fromDate != null && fromDate!= reservation.getFromDate()) {
            reservation.setFromDate(fromDate);
        }
        return this;
    }

    public UpdateReservationHelper toDate(LocalDate toDate) {
        if(toDate != null && toDate != reservation.getToDate()) {
            reservation.setToDate(toDate);
        }
        return this;
    }

    public UpdateReservationHelper property(Property property) {
        if(property != null && !property.equals(reservation.getProperty())) {
            reservation.setProperty(property);
        }
        return this;
    }

    public UpdateReservationHelper income(Income income) {
        if(income != null && !income.equals(reservation.getIncome())) {
            reservation.setIncome(income);
        }
        return this;
    }

    public UpdateReservationHelper feeList(List<Fee> feeList) {
        if(feeList != null && !feeList.equals(reservation.getFeeList())) {
            reservation.setFeeList(feeList);
        }
        return this;
    }


    public Reservation build(Reservation reservationBody) {
        this.fromDate(reservationBody.getFromDate())
        .toDate(reservationBody.getToDate())
        .property(reservationBody.getProperty())
        .income(reservationBody.getIncome())
        .feeList(reservationBody.getFeeList())
        .reservationDate(reservationBody.getReservationDate());
        return reservation;
    }
}
