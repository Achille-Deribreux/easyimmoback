package com.easyimmo.property.model;

import javax.persistence.*;
import java.util.Objects;

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
    private String address;
    @Column(name="name")
    private String name;
    @Column(name="type")
    private Type type;
    @Column(name="rentType")
    private RentType rentType;
    @Column(name="buyPrice")
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer prixAchat) {
        this.buyPrice = prixAchat;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
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
