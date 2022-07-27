package com.easyimmo.reservation.dto;

import java.time.LocalDate;

public class ReservationCriteria {

    private Integer propertyId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDate reservationDate;

    public ReservationCriteria() {
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public ReservationCriteria propertyId(Integer propertyId) {
        this.propertyId = propertyId;
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public ReservationCriteria fromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public ReservationCriteria toDate(LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationCriteria reservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

}
