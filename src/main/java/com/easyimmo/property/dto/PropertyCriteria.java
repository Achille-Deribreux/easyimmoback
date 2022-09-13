package com.easyimmo.property.dto;

import com.easyimmo.property.model.Property;

public class PropertyCriteria {

    private Property.Type type;
    private Property.RentType rentType;
    private String name;
    private Integer lowPrice;
    private Integer highPrice;
    private Integer pageSize;
    private Integer pageNumber;
    private Integer userId;

    public Property.Type getType() {
        return type;
    }

    public void setType(Property.Type type) {
        this.type = type;
    }

    public PropertyCriteria type (Property.Type type){
        setType(type);
        return this;
    }

    public Property.RentType getRentType() {
        return rentType;
    }

    public void setRentType(Property.RentType rentType) {
        this.rentType = rentType;
    }

    public PropertyCriteria rentType (Property.RentType type){
        setRentType(type);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyCriteria name(String name){
        setName(name);
        return this;
    }

    public Integer getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Integer lowPrice) {
        this.lowPrice = lowPrice;
    }

    public PropertyCriteria lowPrice(Integer lowPrice){
        setLowPrice(lowPrice);
        return this;
    }


    public Integer getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Integer highPrice) {
        this.highPrice = highPrice;
    }

    public PropertyCriteria highPrice(Integer highPrice){
        setHighPrice(highPrice);
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public PropertyCriteria pageSize(Integer pageSize){
        setPageSize(pageSize);
        return this;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public PropertyCriteria pageNumber(Integer pageNumber){
        setPageNumber(pageNumber);
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PropertyCriteria userId(Integer userId){
        setUserId(userId);
        return this;
    }
}
