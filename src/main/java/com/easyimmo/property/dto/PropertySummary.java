package com.easyimmo.property.dto;

import com.easyimmo.property.model.Property;

public class PropertySummary {
    private Integer id;
    private String address;
    private String name;
    private Property.Type type;

    public PropertySummary() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PropertySummary id(Integer id) {
        this.id = id;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PropertySummary address(String address) {
        this.address = address;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PropertySummary name(String name) {
        this.name = name;
        return this;
    }

    public Property.Type getType() {
        return type;
    }

    public void setType(Property.Type type) {
        this.type = type;
    }

    public PropertySummary type(Property.Type type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "PropertySummary{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
