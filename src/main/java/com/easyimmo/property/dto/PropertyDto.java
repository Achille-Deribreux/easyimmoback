package com.easyimmo.property.dto;


import java.util.Objects;

import com.easyimmo.property.model.Property;

public class PropertyDto {

    private Integer id;
    private String address;
    private String name;
    private Property.Type type;
    private Property.RentType rentType;
    private Integer prixAchat;
    private Integer userId;

    public PropertyDto() {
    }

    public PropertyDto(Integer id, String address, String name, Property.Type type, Property.RentType rentType, Integer prixAchat) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.type = type;
        this.rentType = rentType;
        this.prixAchat = prixAchat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PropertyDto id(Integer id){
        setId(id);
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertyDto address (String address){
        setAddress(address);
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertyDto name(String name) {
        this.name = name;
        return this;
    }

    public Property.Type getType() {
        return type;
    }

    public void setType(Property.Type type) {
        this.type = type;
    }

    public PropertyDto type(Property.Type type) {
        this.type = type;
        return this;
    }

    public Integer getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Integer prixAchat) {
        this.prixAchat = prixAchat;
    }

    public PropertyDto prixAchat(Integer buyPrice){
        setPrixAchat(buyPrice);
        return this;
    }

    public Property.RentType getRentType() {
        return rentType;
    }

    public void setRentType(Property.RentType rentType) {
        this.rentType = rentType;
    }

    public PropertyDto rentType(Property.RentType rentType){
        setRentType(rentType);
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PropertyDto userId(Integer userId){
        setUserId(userId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropertyDto that = (PropertyDto) o;
        return Objects.equals(id, that.id) && Objects.equals(address, that.address) && Objects.equals(name, that.name) && type == that.type && rentType == that.rentType && Objects.equals(prixAchat, that.prixAchat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, name, type, rentType, prixAchat);
    }

    @Override
    public String toString() {
        return "PropertyDto{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", prixAchat=" + prixAchat +
                '}';
    }
}
