package com.easyimmo.reservation.dto;

import java.time.LocalDate;

public class ReservationBody {
    private Integer id;
    private LocalDate reservationDate;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer propertyId;
    private Integer amount;

    public ReservationBody() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReservationBody id (Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationBody reservationDate (LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public ReservationBody fromDate (LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public ReservationBody toDate (LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public ReservationBody propertyId (Integer propertyId) {
        this.propertyId = propertyId;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ReservationBody amount (Integer amount) {
        this.amount = amount;
        return this;
    }
}
