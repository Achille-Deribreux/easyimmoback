package com.easyimmo.fee;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyimmo.EntityBuilder;
import com.easyimmo.common.exception.FeeNotFoundException;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.repository.FeeRepository;
import com.easyimmo.fees.service.FeeService;
import com.easyimmo.property.model.Property;

@SpringBootTest
class FeeServiceUTest {

    @Mock
    FeeRepository feeRepository;

    @Mock
    CustomValidator validator;

    @InjectMocks
    FeeService feeService;

    @Test
    void getFeeByIdTest() {
     //Given
        Integer id = 1;
        //When
        Mockito.when(feeRepository.findById(id)).thenReturn(Optional.of(new Fee()));
        feeService.getFeeById(id);
        //Then
        Mockito.verify(feeRepository,Mockito.times(1)).findById(id);
    }

    @Test
    void getFeeByIdExceptionTest() {
        //Given
        Integer id = 1;
        //When & Then
        Assertions.assertThrows(FeeNotFoundException.class, () -> feeService.getFeeById(id));
    }

    @Test
    void getAllFeesTest() {
        //Given
        FeeCriteria criteria = new FeeCriteria()
                .propertyId(1)
                .minDate(LocalDate.now())
                .maxDate(LocalDate.now())
                .minAmount(100)
                .maxAmount(200)
                .description("description")
                .propertyName("name")
                .pageNumber(1)
                .pageSize(10);
        //When
        feeService.getAllFees(criteria);
        //Then
        Mockito.verify(feeRepository, Mockito.times(1)).findFeeByMultipleCriteria(criteria);
    }

    @Test
    void deleteFeeByIdTest() {
        //Given
        Integer id = 1;
        Fee fee = EntityBuilder.buildFee();
        //When
        Mockito.when(feeRepository.findById(id)).thenReturn(Optional.of(fee));
        feeService.deleteById(id);
        //Then
        Mockito.verify(feeRepository, Mockito.times(1)).delete(fee);
    }

    @Test
    void addFeeTest() {
        //Given
        Fee feeToAdd = EntityBuilder.buildFee();
        //When
        feeService.addFee(feeToAdd);
        //Then
        Mockito.verify(feeRepository, Mockito.times(1)).save(feeToAdd);
    }

    @Test
    void updateFeeTest() {
        //Given
        Fee originalFee = EntityBuilder.buildFee().id(100);
        Fee feeBody = new Fee().amount(12021).description("description").supplier("supplier").date(LocalDate.now()).property(new Property().address("address").name("name").id(1));
        Fee updatedFee = feeBody.id(100);
        //When
        Mockito.when(feeRepository.findById(originalFee.getId())).thenReturn(Optional.of(originalFee));
        feeService.updateFee(originalFee.getId(),feeBody);
        //Then
        Mockito.verify(feeRepository, Mockito.times(1)).save(updatedFee);
    }

    @Test
    void getTotalFeesFromTest() {
        //Given
        Integer propertyId = 5;
        LocalDate fromDate = LocalDate.now().minusDays(10);
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).minDate(fromDate);
        //When
        feeService.getTotalFeesFrom(propertyId, fromDate);
        //Then
        Mockito.verify(feeRepository, Mockito.times(1)).findFeeByMultipleCriteria(feeCriteria);
    }

    @Test
    void getLastFeeTest() {
        //Given
        Integer propertyId = 5;
        Integer nbFees = 10;
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).pageSize(nbFees).pageNumber(1);
        //When
        feeService.getLastFees(propertyId, nbFees);
        //Then
        Mockito.verify(feeRepository, Mockito.times(1)).findFeeByMultipleCriteria(feeCriteria);
    }
}
