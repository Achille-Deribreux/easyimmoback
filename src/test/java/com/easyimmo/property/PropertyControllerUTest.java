package com.easyimmo.property;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.easyimmo.common.utils.Converter;
import com.easyimmo.property.controllers.PropertyController;
import com.easyimmo.property.service.PropertyService;

@SpringBootTest
public class PropertyControllerUTest {

    @Mock
    PropertyService propertyService;

    @Mock
    Converter converter;

    @InjectMocks
    PropertyController propertyController;
}
