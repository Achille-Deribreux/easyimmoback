package com.easyimmo.reservation.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ReservationSummary {

    private Integer id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String propertyName;
    private Integer price;

    public ReservationSummary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReservationSummary id (Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public ReservationSummary fromDate (LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public ReservationSummary toDate (LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public ReservationSummary propertyName (String propertyName) {
        this.propertyName = propertyName;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public ReservationSummary price (Integer price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "ReservationSummary{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", propertyName='" + propertyName + '\'' +
                ", price=" + price +
                '}';
    }
}
