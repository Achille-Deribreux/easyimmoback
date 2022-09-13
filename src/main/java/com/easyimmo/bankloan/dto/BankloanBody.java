package com.easyimmo.bankloan.dto;

import java.time.LocalDate;

public class BankloanBody {

    private Integer id;
    private Long totalAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long monthlyPayment;
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

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BankloanBody totalAmount(Long totalAmount){
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

    public Long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BankloanBody monthlyPayment(Long monthlyPayment){
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
