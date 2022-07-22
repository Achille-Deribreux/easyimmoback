package com.easyimmo.common.utils;

import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.incomes.dto.IncomeDto;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.dto.PropertyDto;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    @Autowired
    private PropertyService propertyService;

    public Converter() {
    }

    public Fee convert(FeeDto feeDto){
        return new Fee(
                feeDto.getId(),
                propertyService.getById(feeDto.getPropertyId()),
                feeDto.getSupplier(),
                feeDto.getDescription(),
                feeDto.getAmount(),
                feeDto.getDate()
        );
    }

    public FeeDto convert(Fee fee){
        return new FeeDto(
                fee.getId(),
                fee.getProperty().getId(),
                fee.getSupplier(),
                fee.getDescription(),
                fee.getAmount(),
                fee.getDate()
        );
    }

     public Property convert(PropertyDto propertyDto){
        return new Property(
                propertyDto.getId(),
                propertyDto.getAddress(),
                propertyDto.getName(),
                propertyDto.getType(),
                propertyDto.getRentType(),
                propertyDto.getPrixAchat()
        );
    }

     public PropertyDto convert(Property property){
        return new PropertyDto(
                property.getId(),
                property.getAddress(),
                property.getName(),
                property.getType(),
                property.getRentType(),
                property.getBuyPrice()
        );
    }

    public IncomeDto convert(Income income){
        return new IncomeDto(
                income.getId(),
                income.getProperty().getId(),
                income.getDescription(),
                income.getAmount(),
                income.getDate()
                );
    }

    public Income convert(IncomeDto incomeDto){
        return new Income(
                incomeDto.getId(),
                propertyService.getById(incomeDto.getPropertyId()),
                incomeDto.getAmount(),
                incomeDto.getDescription(),
                incomeDto.getDate(),
                null
        );
    }

    public List<PropertyDto>convertPropertyList(List<Property> propertyList){
        return propertyList.stream().map(this::convert).collect(Collectors.toList());
    }

    public List<FeeDto> convertFeeList(List<Fee> feeList){
        return feeList.stream().map(this::convert).collect(Collectors.toList());
    }

    public List<IncomeDto> convertIncomeList(List<Income> incomeList){
        return incomeList.stream().map(this::convert).collect(Collectors.toList());
    }
}
