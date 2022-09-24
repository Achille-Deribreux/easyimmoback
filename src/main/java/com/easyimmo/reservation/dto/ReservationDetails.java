package com.easyimmo.reservation.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.incomes.dto.IncomeSummary;
import com.easyimmo.property.dto.PropertyDto;

public class ReservationDetails {
    private Integer id;
    private LocalDate reservationDate;
    private LocalDate fromDate;
    private LocalDate toDate;
    private PropertyDto property;
    private IncomeSummary income;
    private List<FeeDto> feeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ReservationDetails id (Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public ReservationDetails reservationDate (LocalDate reservationDate) {
        this.reservationDate = reservationDate;
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public ReservationDetails fromDate (LocalDate fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public ReservationDetails toDate (LocalDate toDate) {
        this.toDate = toDate;
        return this;
    }

    public PropertyDto getProperty() {
        return property;
    }

    public void setProperty(PropertyDto property) {
        this.property = property;
    }

    public ReservationDetails property (PropertyDto property) {
        this.property = property;
        return this;
    }

    public IncomeSummary getIncome() {
        return income;
    }

    public void setIncome(IncomeSummary income) {
        this.income = income;
    }

    public ReservationDetails income (IncomeSummary income) {
        this.income = income;
        return this;
    }

    public List<FeeDto> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<FeeDto> feeList) {
        this.feeList = feeList;
    }

    public ReservationDetails feeList (List<FeeDto> feeList) {
        this.feeList = feeList;
        return this;
    }

    @Override
    public String toString() {
        return "ReservationDetails{" +
                "id=" + id +
                ", reservationDate=" + reservationDate +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", property=" + property +
                ", income=" + income +
                ", feeList=" + feeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDetails that = (ReservationDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(reservationDate, that.reservationDate) && Objects.equals(fromDate, that.fromDate) && Objects.equals(toDate, that.toDate) && Objects.equals(property, that.property) && Objects.equals(income, that.income) && Objects.equals(feeList, that.feeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationDate, fromDate, toDate, property, income, feeList);
    }
}
