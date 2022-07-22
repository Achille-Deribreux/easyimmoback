package com.easyimmo.incomes.model;

import com.easyimmo.property.model.Property;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
@Entity
@Table(name="income")
public class Income {

    public enum IncomeType {
        LONGRENT, SHORTRENT, EXCEPTIONAL
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="property_id", referencedColumnName = "id")
    private Property property;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "income_type")
    @Enumerated
    private IncomeType incomeType;

    public Income() {
    }

    public Income(Integer id, Property property, Integer amount, String description, LocalDate date, IncomeType incomeType) {
        this.id = id;
        this.property = property;
        this.amount = amount;
        this.description = description;
        this.date = date;
        this.incomeType = incomeType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return Objects.equals(id, income.id) && Objects.equals(property, income.property) && Objects.equals(amount, income.amount) && Objects.equals(description, income.description) && Objects.equals(date, income.date) && incomeType == income.incomeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, property, amount, description, date, incomeType);
    }
}
