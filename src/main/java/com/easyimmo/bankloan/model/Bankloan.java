package com.easyimmo.bankloan.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.easyimmo.property.model.Property;

@Entity
@Table(name="bankloan")
public class Bankloan {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="totalAmount")
    @NotNull
    private Long totalAmount;

    @Column(name="startDate")
    @NotNull
    private LocalDate startDate;

    @Column(name="endDate")
    @NotNull
    private LocalDate endDate;

    @Column(name = "monthlyPayment")
    @NotNull
    private Long monthlyPayment;

    @ManyToOne
    @JoinColumn(name="property_id", referencedColumnName = "id")
    @NotNull
    private Property property;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bankloan id(Integer id){
        setId(id);
        return this;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Bankloan totalAmount(Long totalAmount){
        setTotalAmount(totalAmount);
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Bankloan startDate(LocalDate startDate){
        setStartDate(startDate);
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Bankloan endDate(LocalDate endDate){
        setEndDate(endDate);
        return this;
    }

    public Long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Bankloan monthlyPayment(Long monthlyPayment){
        setMonthlyPayment(monthlyPayment);
        return this;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Bankloan property(Property property){
        setProperty(property);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bankloan bankloan = (Bankloan) o;
        return Objects.equals(id, bankloan.id) && Objects.equals(totalAmount, bankloan.totalAmount) && Objects.equals(startDate, bankloan.startDate) && Objects.equals(endDate, bankloan.endDate) && Objects.equals(monthlyPayment, bankloan.monthlyPayment) && Objects.equals(property, bankloan.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalAmount, startDate, endDate, monthlyPayment, property);
    }
}
