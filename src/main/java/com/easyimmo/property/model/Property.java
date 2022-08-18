package com.easyimmo.property.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="property")
public class Property {

    public enum Type {
        HOUSE, APPARTMENT
    }

    public enum RentType {
        SHORT, LONG
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="address")
    @NotNull
    private String address;

    @Column(name="name")
    @NotNull
    private String name;

    @Column(name="type")
    @NotNull
    private Type type;

    @Column(name="rentType")
    @NotNull
    private RentType rentType;

    @Column(name="buyPrice")
    @NotNull
    private Integer buyPrice;


    public Property() {
    }

    public Property(Integer id, String address, String name, Type type, RentType rentType, Integer prixAchat) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.type = type;
        this.rentType = rentType;
        this.buyPrice = prixAchat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Property id(Integer id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Property address(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Property name(String name) {
        this.name = name;
        return this;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Property type(Type type) {
        this.type = type;
        return this;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Property buyPrice(Integer buyPrice){
        setBuyPrice(buyPrice);
        return this;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public Property rentType(RentType rentType){
        setRentType(rentType);
        return this;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", rentType=" + rentType +
                ", prixAchat=" + buyPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return Objects.equals(id, property.id) && Objects.equals(address, property.address) && Objects.equals(name, property.name) && type == property.type && rentType == property.rentType && Objects.equals(buyPrice, property.buyPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, name, type, rentType, buyPrice);
    }
}
