package com.easyimmo.incomes.dto;

import java.time.LocalDate;

public class IncomeSummary {

    private Integer id;
    private LocalDate date;
    private Integer amount;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IncomeSummary id(Integer id) {
        this.id = id;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public IncomeSummary date(LocalDate date) {
        this.date = date;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public IncomeSummary amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncomeSummary description(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "IncomeSummary{" +
                "id=" + id +
                ", date=" + date +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }
}
