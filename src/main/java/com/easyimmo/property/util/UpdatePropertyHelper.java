package com.easyimmo.property.util;

import com.easyimmo.property.model.Property;

public class UpdatePropertyHelper {

    private Property property;

    public UpdatePropertyHelper(Property property) {
        this.property = property;
    }

    public static UpdatePropertyHelper of(Property property){
        return new UpdatePropertyHelper(property);
    }

    public UpdatePropertyHelper address(String address){
        if(address!=null && !address.equals(property.getAddress())){
            property.setAddress(address);
        }
        return this;
    }

    public UpdatePropertyHelper name(String name){
        if(name!=null && !name.equals(property.getName())){
            property.setName(name);
        }
        return this;
    }

    public UpdatePropertyHelper type(Property.Type type){
        if(type!=null && !type.equals(property.getType())){
            property.setType(type);
        }
        return this;
    }

    public UpdatePropertyHelper rentType(Property.RentType type){
        if(type!=null && !type.equals(property.getRentType())){
            property.setRentType(type);
        }
        return this;
    }

    public UpdatePropertyHelper buyPrice(Integer buyPrice){
        if(buyPrice!=null && !buyPrice.equals(property.getBuyPrice())){
            property.setBuyPrice(buyPrice);
        }
        return this;
    }

    public Property build(Property body){
        this
                .buyPrice(body.getBuyPrice())
                .rentType(body.getRentType())
                .type(body.getType())
                .rentType(body.getRentType())
                .name(body.getName())
                .address(body.getAddress());
        return property;
    }
}
