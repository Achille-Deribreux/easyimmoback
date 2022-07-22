package com.easyimmo.incomes.dto;

import java.time.LocalDate;
import java.util.Objects;

public class IncomeDto {

    private Integer id;
    private Integer propertyId;
    private String description;
    private Integer amount;
    private LocalDate date;

    public IncomeDto() {
    }

    public IncomeDto(Integer id, Integer propertyId, String description, Integer amount, LocalDate date) {
        this.id = id;
        this.propertyId = propertyId;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeDto incomeDto = (IncomeDto) o;
        return Objects.equals(id, incomeDto.id) && Objects.equals(propertyId, incomeDto.propertyId) && Objects.equals(description, incomeDto.description) && Objects.equals(amount, incomeDto.amount) && Objects.equals(date, incomeDto.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyId, description, amount, date);
    }
}
