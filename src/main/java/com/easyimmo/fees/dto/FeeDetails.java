package com.easyimmo.fees.dto;

import com.easyimmo.property.model.Property;

import java.time.LocalDate;

public class FeeDetails {
    private Integer id;
    private Property property;
    private String supplier;
    private String description;
    private Integer amount;
    private LocalDate date;

    public FeeDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FeeDetails id(Integer id) {
        this.id = id;
        return this;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public FeeDetails property(Property property) {
        this.property = property;
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public FeeDetails supplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FeeDetails description(String description) {
        this.description = description;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public FeeDetails amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FeeDetails date(LocalDate date) {
        this.date = date;
        return this;
    }
}
