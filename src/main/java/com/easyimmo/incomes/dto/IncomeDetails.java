package com.easyimmo.incomes.dto;

import java.time.LocalDate;

import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.dto.PropertySummary;

public class IncomeDetails {

    private Integer id;
    private PropertySummary property;
    private String description;
    private Integer amount;
    private LocalDate date;
    private Income.IncomeType incomeType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IncomeDetails id(Integer id){
        setId(id);
        return this;
    }

    public PropertySummary getProperty() {
        return property;
    }

    public void setProperty(PropertySummary property) {
        this.property = property;
    }

    public IncomeDetails property(PropertySummary property){
        setProperty(property);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncomeDetails description(String description){
        setDescription(description);
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public IncomeDetails amount(Integer amount){
        setAmount(amount);
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public IncomeDetails date(LocalDate date){
        setDate(date);
        return this;
    }

    public Income.IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(Income.IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    public IncomeDetails incomeType (Income.IncomeType incomeType){
        setIncomeType(incomeType);
        return this;
    }

    @Override
    public String toString() {
        return "IncomeDetails{" +
                "id=" + id +
                ", property=" + property +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", incomeType=" + incomeType +
                '}';
    }
}
