package com.easyimmo.property.dto;

import java.util.List;

import com.easyimmo.bankloan.dto.BankLoanSummary;
import com.easyimmo.fees.dto.FeeSummary;
import com.easyimmo.incomes.dto.IncomeSummary;
import com.easyimmo.reservation.dto.ReservationSummary;

public class PropertyDetails {
    private Integer id;
    private String address;
    private String name;
    private String rentType;
    private String type;
    private Integer buyPrice;
    private BankLoanSummary bankLoanSummary;
    private Integer yearlyFees;
    private Integer yearlyIncomes;
    private Integer monthlyFees;
    private Integer monthlyIncomes;
    private List<FeeSummary> fees;
    private List<IncomeSummary> incomes;
    private List<ReservationSummary> reservations;

    public PropertyDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PropertyDetails id(Integer id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertyDetails address(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyDetails name(String name) {
        this.name = name;
        return this;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public PropertyDetails rentType(String rentType) {
        this.rentType = rentType;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PropertyDetails type(String type) {
        this.type = type;
        return this;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public PropertyDetails buyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
        return this;
    }

    public BankLoanSummary getBankLoanSummary() {
        return bankLoanSummary;
    }

    public void setBankLoanSummary(BankLoanSummary bankLoanSummary) {
        this.bankLoanSummary = bankLoanSummary;
    }

    public PropertyDetails bankLoanSummary(BankLoanSummary bankLoanSummary) {
        this.bankLoanSummary = bankLoanSummary;
        return this;
    }

    public Integer getYearlyFees() {
        return yearlyFees;
    }

    public void setYearlyFees(Integer yearlyFees) {
        this.yearlyFees = yearlyFees;
    }

    public PropertyDetails yearlyFees(Integer yearlyFees) {
        this.yearlyFees = yearlyFees;
        return this;
    }

    public Integer getYearlyIncomes() {
        return yearlyIncomes;
    }

    public void setYearlyIncomes(Integer yearlyIncomes) {
        this.yearlyIncomes = yearlyIncomes;
    }

    public PropertyDetails yearlyIncomes(Integer yearlyIncomes) {
        this.yearlyIncomes = yearlyIncomes;
        return this;
    }

    public Integer getMonthlyFees() {
        return monthlyFees;
    }

    public void setMonthlyFees(Integer monthlyFees) {
        this.monthlyFees = monthlyFees;
    }

    public PropertyDetails monthlyFees(Integer monthlyFees) {
        this.monthlyFees = monthlyFees;
        return this;
    }

    public Integer getMonthlyIncomes() {
        return monthlyIncomes;
    }

    public void setMonthlyIncomes(Integer monthlyIncomes) {
        this.monthlyIncomes = monthlyIncomes;
    }

    public PropertyDetails monthlyIncomes(Integer monthlyIncomes) {
        this.monthlyIncomes = monthlyIncomes;
        return this;
    }

    public List<FeeSummary> getFees() {
        return fees;
    }

    public void setFees(List<FeeSummary> fees) {
        this.fees = fees;
    }

    public PropertyDetails fees(List<FeeSummary> fees) {
        this.fees = fees;
        return this;
    }

    public List<IncomeSummary> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<IncomeSummary> incomes) {
        this.incomes = incomes;
    }

    public PropertyDetails incomes(List<IncomeSummary> incomes) {
        this.incomes = incomes;
        return this;
    }

    public List<ReservationSummary> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationSummary> reservations) {
        this.reservations = reservations;
    }

    public PropertyDetails reservations(List<ReservationSummary> reservations) {
        this.reservations = reservations;
        return this;
    }

    @Override
    public String toString() {
        return "PropertyDetails{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", rentType='" + rentType + '\'' +
                ", type='" + type + '\'' +
                ", buyPrice=" + buyPrice +
                ", bankLoanSummary=" + bankLoanSummary +
                ", yearlyFees=" + yearlyFees +
                ", yearlyIncomes=" + yearlyIncomes +
                ", monthlyFees=" + monthlyFees +
                ", monthlyIncomes=" + monthlyIncomes +
                ", fees=" + fees +
                ", incomes=" + incomes +
                ", reservations=" + reservations +
                '}';
    }
}
