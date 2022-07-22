package com.easyimmo.incomes.dto;

import com.easyimmo.incomes.model.Income;

import java.time.LocalDate;
import java.util.Objects;

public class IncomeCriteria {

    private String propertyName;
    private Integer minAmount;
    private Integer maxAmount;
    private String description;
    private LocalDate minDate;
    private LocalDate maxDate;
    private Integer propertyId;
    private Income.IncomeType type;

    public IncomeCriteria() {
    }

    public IncomeCriteria(String propertyName, Integer minAmount, Integer maxAmount, String description, LocalDate minDate, LocalDate maxDate, Integer propertyId, Income.IncomeType type) {
        this.propertyName = propertyName;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.description = description;
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.propertyId = propertyId;
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDate minDate) {
        this.minDate = minDate;
    }

    public LocalDate getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDate maxDate) {
        this.maxDate = maxDate;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public Income.IncomeType getType() {
        return type;
    }

    public void setType(Income.IncomeType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeCriteria that = (IncomeCriteria) o;
        return Objects.equals(propertyName, that.propertyName) && Objects.equals(minAmount, that.minAmount) && Objects.equals(maxAmount, that.maxAmount) && Objects.equals(description, that.description) && Objects.equals(minDate, that.minDate) && Objects.equals(maxDate, that.maxDate) && Objects.equals(propertyId, that.propertyId) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, minAmount, maxAmount, description, minDate, maxDate, propertyId, type);
    }
}
