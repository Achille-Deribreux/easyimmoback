package com.easyimmo.bankloan.dto;

import java.time.LocalDate;

public class BankloanBody {

    private Integer id;
    private Integer totalAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthlyPayment;
    private Integer propertyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BankloanBody id(Integer id){
        setId(id);
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BankloanBody totalAmount(Integer totalAmount){
        setTotalAmount(totalAmount);
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BankloanBody startDate(LocalDate startDate){
        setStartDate(startDate);
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BankloanBody endDate(LocalDate endDate){
        setEndDate(endDate);
        return this;
    }

    public Integer getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Integer monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BankloanBody monthlyPayment(Integer monthlyPayment){
        setMonthlyPayment(monthlyPayment);
        return this;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public BankloanBody propertyId(Integer propertyId){
        setPropertyId(propertyId);
        return this;
    }
}
