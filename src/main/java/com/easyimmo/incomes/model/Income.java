package com.easyimmo.incomes.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.easyimmo.property.model.Property;
import com.easyimmo.reservation.model.Reservation;

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
    @NotNull
    private Property property;

    @Column(name = "amount")
    @NotNull
    private Integer amount;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "income_type")
    @Enumerated
    @NotNull
    private IncomeType incomeType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id", referencedColumnName = "income_id")
    private Reservation reservation;

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

    public Income id(Integer id) {
        this.id = id;
        return this;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Income property(Property property) {
        this.property = property;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Income amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Income description(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Income date(LocalDate date) {
        this.date = date;
        return this;
    }

    public IncomeType getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
    }

    public Income incomeType(IncomeType incomeType) {
        this.incomeType = incomeType;
        return this;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Income reservation(Reservation reservation){
        setReservation(reservation);
        return this;
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
