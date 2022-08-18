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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Property.Type getType() {
        return type;
    }

    public void setType(Property.Type type) {
        this.type = type;
    }

    public Integer getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Integer prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Property.RentType getRentType() {
        return rentType;
    }

    public void setRentType(Property.RentType rentType) {
        this.rentType = rentType;
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
