package com.easyimmo.fees.dto;

import java.time.LocalDate;
import java.util.Objects;

public class FeeDto {
    private Integer id;
    private Integer propertyId;
    private String supplier;
    private String description;
    private Integer amount;
    private LocalDate date;

    public FeeDto() {
    }

    public FeeDto(Integer id, Integer propertyId, String supplier, String description, Integer amount, LocalDate date) {
        this.id = id;
        this.propertyId = propertyId;
        this.supplier = supplier;
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

    public FeeDto id (Integer id){
        setId(id);
        return this;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public FeeDto propertyId (Integer propertyId){
        setPropertyId(propertyId);
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public FeeDto supplier (String supplier){
        setSupplier(supplier);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FeeDto description (String description){
        setDescription(description);
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public FeeDto amount (Integer amount){
        setAmount(amount);
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FeeDto date (LocalDate date){
        setDate(date);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeeDto fee = (FeeDto) o;
        return Objects.equals(id, fee.id) && Objects.equals(propertyId, fee.propertyId) && Objects.equals(supplier, fee.supplier) && Objects.equals(description, fee.description) && Objects.equals(amount, fee.amount) && Objects.equals(date, fee.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, propertyId, supplier, description, amount, date);
    }

    @Override
    public String toString() {
        return "Fee{" +
                "id=" + id +
                ", property_id=" + propertyId +
                ", supplier='" + supplier + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
