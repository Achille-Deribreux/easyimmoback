package com.easyimmo.bankloan.dto;

import java.time.LocalDate;

public class BankloanDetails {
    private Integer id;
    private Integer totalAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthlyPayment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BankloanDetails id(Integer id){
        setId(id);
        return this;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BankloanDetails totalAmount(Integer totalAmount){
        setTotalAmount(totalAmount);
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public BankloanDetails startDate(LocalDate startDate){
        setStartDate(startDate);
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BankloanDetails endDate(LocalDate endDate){
        setEndDate(endDate);
        return this;
    }

    public Integer getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Integer monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BankloanDetails monthlyPayment(Integer monthlyPayment){
        setMonthlyPayment(monthlyPayment);
        return this;
    }
}
