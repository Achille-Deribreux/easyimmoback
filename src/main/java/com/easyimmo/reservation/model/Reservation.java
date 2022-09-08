package com.easyimmo.reservation.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.easyimmo.fees.model.Fee;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.model.Property;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "reservation_date")
    @NotNull
    private LocalDate reservationDate;

    @Column(name = "from_date")
    @NotNull
    private LocalDate fromDate;

    @Column(name = "to_date")
    @NotNull
    private LocalDate toDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="property_id", referencedColumnName = "id")
    @NotNull
    private Property property;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="income_id", referencedColumnName = "id")
    private Income income;

    @OneToMany(mappedBy = "reservation",fetch = FetchType.LAZY)
    private List<Fee> feeList;

    public Reservation() {
    }

    public Reservation(Integer id, LocalDate reservationDate, LocalDate fromDate, LocalDate toDate, Property property, Income income, List<Fee> feeList) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.property = property;
        this.income = income;
        this.feeList = feeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reservation id(Integer id){
        setId(id);
        return this;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Reservation reservationDate(LocalDate reservationDate){
        setReservationDate(reservationDate);
        return this;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public Reservation fromDate(LocalDate fromDate){
        setFromDate(fromDate);
        return this;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Reservation toDate(LocalDate toDate){
        setToDate(toDate);
        return this;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Reservation property(Property property){
        setProperty(property);
        return this;
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Reservation income(Income income){
        setIncome(income);
        return this;
    }

    public List<Fee> getFeeList() {
        return feeList;
    }

    public void setFeeList(List<Fee> feeList) {
        this.feeList = feeList;
    }

    public Reservation feeList(List<Fee> feeList){
        setFeeList(feeList);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(reservationDate, that.reservationDate) && Objects.equals(fromDate, that.fromDate) && Objects.equals(toDate, that.toDate) && Objects.equals(property, that.property) && Objects.equals(income, that.income) && Objects.equals(feeList, that.feeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationDate, fromDate, toDate, property, income, feeList);
    }
}
