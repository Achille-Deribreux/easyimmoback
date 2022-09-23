package com.easyimmo.incomes.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.easyimmo.incomes.model.Income;

public class IncomeBody {

    private Integer id;
    private Integer propertyId;
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

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Income.IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(Income.IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeBody that = (IncomeBody) o;
        return Objects.equals(id, that.id) && Objects.equals(propertyId, that.propertyId) && Objects.equals(description, that.description) && Objects.equals(amount, that.amount) && Objects.equals(date, that.date) && incomeType == that.incomeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyId, description, amount, date, incomeType);
    }
}
