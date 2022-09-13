package com.easyimmo.fees.dto;

import java.time.LocalDate;
import java.util.Objects;

public class FeeCriteria {

    private String propertyName;
    private String supplier;
    private Integer minAmount;
    private Integer maxAmount;
    private String description;
    private LocalDate minDate;
    private LocalDate maxDate;
    private Integer propertyId;
    private Integer pageSize;
    private Integer pageNumber;
    private Integer userId;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public FeeCriteria propertyName(String propertyName){
        setPropertyName(propertyName);
        return this;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public FeeCriteria supplier(String supplier){
        setSupplier(supplier);
        return this;
    }

    public Integer getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Integer minAmount) {
        this.minAmount = minAmount;
    }

    public FeeCriteria minAmount(Integer amount){
        setMinAmount(amount);
        return this;
    }

    public Integer getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Integer maxAmount) {
        this.maxAmount = maxAmount;
    }

    public FeeCriteria maxAmount(Integer amount){
        setMaxAmount(amount);
        return this;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FeeCriteria description(String description){
        setDescription(description);
        return this;
    }

    public LocalDate getMinDate() {
        return minDate;
    }

    public void setMinDate(LocalDate minDate) {
        this.minDate = minDate;
    }

    public FeeCriteria minDate(LocalDate date){
        setMinDate(date);
        return this;
    }

    public LocalDate getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(LocalDate maxDate) {
        this.maxDate = maxDate;
    }

    public FeeCriteria maxDate(LocalDate date){
        setMaxDate(date);
        return this;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public FeeCriteria propertyId(Integer propertyId){
        setPropertyId(propertyId);
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public FeeCriteria pageSize(Integer pageSize){
        setPageSize(pageSize);
        return this;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public FeeCriteria pageNumber(Integer pageNumber){
        setPageNumber(pageNumber);
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public FeeCriteria userId (Integer userId){
        setUserId(userId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeeCriteria that = (FeeCriteria) o;
        return Objects.equals(propertyName, that.propertyName) &&  Objects.equals(description, that.description) && Objects.equals(minDate, that.minDate) && Objects.equals(maxDate, that.maxDate) && Objects.equals(propertyId, that.propertyId) && Objects.equals(pageSize, that.pageSize) && Objects.equals(pageNumber, that.pageNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propertyName, supplier, minAmount, maxAmount, description, minDate, maxDate, propertyId, pageSize, pageNumber);
    }
}
