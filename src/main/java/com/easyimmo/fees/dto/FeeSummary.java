package com.easyimmo.fees.dto;

import java.time.LocalDate;

public class FeeSummary {
    private Integer id;
    private LocalDate date;
    private Integer amount;
    private String supplier;

    public FeeSummary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FeeSummary id(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FeeSummary date(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public FeeSummary amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public FeeSummary description(String description) {
        this.supplier = description;
        return this;
    }
}
