package com.easyimmo.incomes.dto;

import com.easyimmo.incomes.model.Income;

import java.time.LocalDate;

public class IncomeCriteria {

    private String propertyName;
    private Integer minAmount;
    private Integer maxAmount;
    private String description;
    private LocalDate minDate;
    private LocalDate maxDate;
    private Integer propertyId;
    private Income.IncomeType type;
    private Integer pageSize;
    private Integer pageNumber;

    public IncomeCriteria() {
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public IncomeCriteria propertyName(String propertyName){
        setPropertyName(propertyName);
        return this;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public IncomeCriteria minAmount(Integer amount){
        setMinAmount(amount);
        return this;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public IncomeCriteria maxAmount(Integer amount){
        setMaxAmount(amount);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public IncomeCriteria description(String description){
        setDescription(description);
        return this;
    }

    public LocalDate getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDate minDate) {
        this.minDate = minDate;
    }

    public IncomeCriteria minDate(LocalDate date){
        setMinDate(date);
        return this;
    }

    public LocalDate getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDate maxDate) {
        this.maxDate = maxDate;
    }

    public IncomeCriteria maxDate(LocalDate date){
        setMaxDate(date);
        return this;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public IncomeCriteria propertyId(Integer propertyId){
        setPropertyId(propertyId);
        return this;
    }

    public Income.IncomeType getType() {
        return type;
    }

    public void setType(Income.IncomeType type) {
        this.type = type;
    }

    public IncomeCriteria type(Income.IncomeType type){
        setType(type);
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public IncomeCriteria pageSize(Integer pageSize){
        setPageSize(pageSize);
        return this;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public IncomeCriteria pageNumber(Integer pageNumber){
        setPageNumber(pageNumber);
        return this;
    }
}
