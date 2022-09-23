package com.easyimmo.common;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyimmo.bankloan.service.BankloanService;
import com.easyimmo.common.utils.Converter;
import com.easyimmo.fees.dto.FeeDetails;
import com.easyimmo.fees.dto.FeeDto;
import com.easyimmo.fees.dto.FeeSummary;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.service.FeeService;
import com.easyimmo.incomes.service.IncomeService;
import com.easyimmo.property.dto.PropertyDto;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.service.PropertyService;
import com.easyimmo.reservation.service.ReservationService;

@SpringBootTest
class ConverterUTest {

    @Mock
    PropertyService propertyService;

    @Mock
    FeeService feeService;

    @Mock
    IncomeService incomeService;

    @Mock
    ReservationService reservationService;

    @Mock
    BankloanService bankloanService;

    @InjectMocks
    Converter converter;

    @Test
    @DisplayName("test to convert a feeDto to a fee")
    @Tag("fee")
    void convertFeeDtoTest() {
        //Given
        Fee expected = ConverterTestData.getFee();
        FeeDto feeDto = ConverterTestData.getFeeDto();
        //When
        Mockito.when(propertyService.getById(1)).thenReturn(new Property().id(1));//TODO REAL PROPERTY FROM TEST DATA
        Fee result = converter.convert(feeDto);
        //Then
        Assertions.assertEquals(expected.getId(),result.getId());
        Assertions.assertEquals(expected.getAmount(),result.getAmount());
        Assertions.assertEquals(expected.getDate(),result.getDate());
        Assertions.assertEquals(expected.getProperty().getId(),result.getProperty().getId());
        Assertions.assertEquals(expected.getSupplier(),result.getSupplier());
    }

    @Test
    @DisplayName("test to convert a fee into a feeDto")
    @Tag("fee")
    void convertFeeTest(){
        //Given
        Fee fee = ConverterTestData.getFee();
        FeeDto expected = ConverterTestData.getFeeDto();
        //When
        FeeDto result = converter.convert(fee);
        //Then
        Assertions.assertEquals(expected.getId(),result.getId());
        Assertions.assertEquals(expected.getAmount(),result.getAmount());
        Assertions.assertEquals(expected.getDate(),result.getDate());
        Assertions.assertEquals(expected.getPropertyId(),result.getPropertyId());
        Assertions.assertEquals(expected.getSupplier(),result.getSupplier());
    }

    @Test
    @DisplayName("test to convert a fee into FeeDetails")
    @Tag("fee")
    void convertToDetailsTest(){
        //Given
        Fee fee = ConverterTestData.getFee();
        FeeDetails expected = ConverterTestData.getFeeDetails();
        //When
        FeeDetails result = converter.convertToDetails(fee);
        //Then
        Assertions.assertEquals(expected.getId(),result.getId());
        Assertions.assertEquals(expected.getAmount(),result.getAmount());
        Assertions.assertEquals(expected.getDate(),result.getDate());
        Assertions.assertEquals(expected.getProperty().getId(),result.getProperty().getId());
        Assertions.assertEquals(expected.getSupplier(),result.getSupplier());
    }

    @Test
    @DisplayName("test to convert a fee into FeeSummary")
    @Tag("fee")
    void convertToSummaryTest(){
        //Given
        Fee fee = ConverterTestData.getFee();
        FeeSummary expected = ConverterTestData.getFeeSummary();
        //When
        FeeSummary result = converter.convertToSummary(fee);
        //Then
        Assertions.assertEquals(expected.getId(),result.getId());
        Assertions.assertEquals(expected.getAmount(),result.getAmount());
        Assertions.assertEquals(expected.getDate(),result.getDate());
        Assertions.assertEquals(expected.getSupplier(),result.getSupplier());
    }

    @Test
    @DisplayName("test to convert a List of Fee into a List of FeeDto")
    @Tag("fee")
    void convertFeeList() {
        //Given
        List<Fee> feeList = List.of(ConverterTestData.getFee());
        List<FeeDto> expected = List.of(ConverterTestData.getFeeDto());
        //When
        List<FeeDto>result = converter.convertFeeList(feeList);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0).getId(),result.get(0).getId());
        Assertions.assertEquals(expected.get(0).getAmount(),result.get(0).getAmount());
        Assertions.assertEquals(expected.get(0).getDate(),result.get(0).getDate());
        Assertions.assertEquals(expected.get(0).getPropertyId(),result.get(0).getPropertyId());
        Assertions.assertEquals(expected.get(0).getSupplier(),result.get(0).getSupplier());
    }

    @Test
    @DisplayName("test to convert a list of fee into a list of FeeSummary")
    @Tag("fee")
    void convertToFeeSummaryListTest(){
        //Given
        List<Fee> feeList = List.of(ConverterTestData.getFee());
        List<FeeSummary> expected = List.of(ConverterTestData.getFeeSummary());
        //When
        List<FeeSummary> result = converter.convertToFeeSummaryList(feeList);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0).getId(),result.get(0).getId());
        Assertions.assertEquals(expected.get(0).getAmount(),result.get(0).getAmount());
        Assertions.assertEquals(expected.get(0).getDate(),result.get(0).getDate());
        Assertions.assertEquals(expected.get(0).getSupplier(),result.get(0).getSupplier());
    }

    @Test
    @DisplayName("test to convert a propertyDto into a Property")
    @Tag("property")
    void convertToPropertyTest() {
        //Given
        PropertyDto propertyDto = ConverterTestData.getPropertyDto();
        Property expected = ConverterTestData.getProperty();
        //When
        Property result = converter.convert(propertyDto);
        //Then
        Assertions.assertEquals(expected.getId(),result.getId());
        Assertions.assertEquals(expected.getName(),result.getName());
        Assertions.assertEquals(expected.getAddress(),result.getAddress());
        Assertions.assertEquals(expected.getType(),result.getType());
        Assertions.assertEquals(expected.getRentType(),result.getRentType());
        Assertions.assertEquals(expected.getBuyPrice(),result.getBuyPrice());
        Assertions.assertEquals(expected.getUserId(),result.getUserId());

    }
}
