package com.easyimmo.reservation.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ReservationSummary {

    private Integer id;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer propertyId;

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

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public ReservationSummary propertyId (Integer propertyId) {
        this.propertyId = propertyId;
        return this;
    }

    @Override
    public String toString() {
        return "ReservationSummary{" +
                "id=" + id +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", propertyId=" + propertyId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationSummary that = (ReservationSummary) o;
        return Objects.equals(id, that.id) && Objects.equals(fromDate, that.fromDate) && Objects.equals(toDate, that.toDate) && Objects.equals(propertyId, that.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromDate, toDate, propertyId);
    }
}
