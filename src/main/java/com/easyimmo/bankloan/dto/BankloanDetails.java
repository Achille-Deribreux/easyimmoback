package com.easyimmo.bankloan.dto;

import java.time.LocalDate;

public class BankloanDetails {
    private Integer id;
    private Long totalAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long monthlyPayment;

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

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BankloanDetails totalAmount(Long totalAmount){
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

    public Long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public BankloanDetails monthlyPayment(Long monthlyPayment){
        setMonthlyPayment(monthlyPayment);
        return this;
    }
}
