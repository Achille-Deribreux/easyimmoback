package com.easyimmo.reservation.dto;

import java.time.LocalDate;
import java.util.List;

public class ReservationBody {
    private Integer id;
    private LocalDate reservationDate;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer propertyId;
    private Integer incomeId;
    private List<Integer> feeIdList;

    public ReservationBody() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public List<Integer> getFeeIdList() {
        return feeIdList;
    }

    public void setFeeIdList(List<Integer> feeIdList) {
        this.feeIdList = feeIdList;
    }
}
