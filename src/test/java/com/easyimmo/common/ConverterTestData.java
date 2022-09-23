package com.easyimmo.common;

import java.time.LocalDate;

import com.easyimmo.fees.dto.FeeDetails;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.dto.FeeSummary;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.property.dto.PropertyDto;
import com.easyimmo.property.dto.PropertySummary;
import com.easyimmo.property.model.Property;

public class ConverterTestData {

    private ConverterTestData() {
    }

    /**
     * FEE DATA
     */
    public static FeeDto getFeeDto(){
        return new FeeDto()
                .id(1)
                .propertyId(1)
                .description("description")
                .supplier("supplier")
                .amount(100)
                .date(LocalDate.now());
    }

    public static Fee getFee(){
        return new Fee()
            .id(1)
            .property(getProperty())
            .description("description")
            .supplier("supplier")
            .amount(100)
            .date(LocalDate.now());
    }

    public static FeeDetails getFeeDetails(){
        return new FeeDetails()
                .id(1)
                .property(getProperty())
                .description("description")
                .supplier("supplier")
                .amount(100)
                .date(LocalDate.now());
    }

    public static FeeSummary getFeeSummary(){
        return new FeeSummary()
                .id(1)
                .supplier("supplier")
                .amount(100)
                .date(LocalDate.now());
    }

    /**
     * PROPERTY DATA
     */

    public static Property getProperty(){
        return new Property()
                .id(1)
                .address("75 test street belgium")
                .name("test property name")
                .type(Property.Type.APPARTMENT)
                .rentType(Property.RentType.LONG)
                .buyPrice(120000)
                .userId(1);
    }

    public static PropertyDto getPropertyDto(){
        return new PropertyDto()
                .id(1)
                .address("75 test street belgium")
                .name("test property name")
                .type(Property.Type.APPARTMENT)
                .rentType(Property.RentType.LONG)
                .prixAchat(120000)
                .userId(1);
    }

    public static PropertySummary getPropertySummary(){
        return new PropertySummary()
                .id(1)
                .address("75 test street belgium")
                .name("test property name")
                .type(Property.Type.APPARTMENT);
    }
}