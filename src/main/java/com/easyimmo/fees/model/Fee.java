package com.easyimmo.fees.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.easyimmo.property.model.Property;
import com.easyimmo.reservation.model.Reservation;

@Entity
@Table(name="fees")
public class Fee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name="property_id", referencedColumnName = "id")
    @NotNull
    private Property property;

    @Column(name="supplier")
    @NotNull
    private String supplier;

    @Column(name="description")
    @NotNull
    private String description;

    @Column(name="price")
    @NotNull
    private Integer amount;

    @Column(name="date")
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="reservation_id", referencedColumnName = "id")
    private Reservation reservation;

    public Fee() {
    }

    public Fee(Integer id, Property property, String supplier, String description, Integer amount, LocalDate date) {
        this.id = id;
        this.property = property;
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

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
        Fee fee = (Fee) o;
        return Objects.equals(id, fee.id) && Objects.equals(property, fee.property) && Objects.equals(supplier, fee.supplier) && Objects.equals(description, fee.description) && Objects.equals(amount, fee.amount) && Objects.equals(date, fee.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, property, supplier, description, amount, date);
    }
}
