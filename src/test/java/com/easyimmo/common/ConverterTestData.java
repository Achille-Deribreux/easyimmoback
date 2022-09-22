package com.easyimmo.common;

import java.time.LocalDate;

import com.easyimmo.fees.dto.FeeDetails;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.dto.FeeSummary;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.property.model.Property;

public class ConverterTestData {

    private ConverterTestData() {
    }

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
            .property(new Property().id(1))
            .description("description")
            .supplier("supplier")
            .amount(100)
            .date(LocalDate.now());
    }

    public static FeeDetails getFeeDetails(){
        return new FeeDetails()
                .id(1)
                .property(new Property().id(1))
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


}
