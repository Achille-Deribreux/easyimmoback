package com.easyimmo.property;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyimmo.common.exception.PropertyNotFoundException;
import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.repository.PropertyRepository;
import com.easyimmo.property.service.PropertyService;

@SpringBootTest
class PropertyServiceUTest {

    @Mock
    PropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @Test
    void getByIdTest() {
        //Given
        Integer id = 1;
        //When
        Mockito.when(propertyRepository.findById(id)).thenReturn(Optional.of(new Property()));
        propertyService.getById(id);
        //Then
        Mockito.verify(propertyRepository,Mockito.times(1)).findById(id);
    }

    @Test
    void getByIdExceptionTest() {
        //Given
        Integer id = 1;
        //When & Then
        Assertions.assertThrows(PropertyNotFoundException.class,()->propertyService.getById(id));
    }

    @Test
    void getAllTest() {
        //Given
        PropertyCriteria propertyCriteria = new PropertyCriteria().name("adjks").pageSize(1).pageNumber(12);
        //When
        propertyService.getAll(propertyCriteria);
        //Then
        Mockito.verify(propertyRepository,Mockito.times(1)).findPropertyByMultipleCriteria(propertyCriteria);
    }
}
