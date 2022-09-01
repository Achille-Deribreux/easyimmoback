package com.easyimmo.property;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

import com.easyimmo.AuthenticationMock;
import com.easyimmo.EntityBuilder;
import com.easyimmo.common.exception.PropertyNotFoundException;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.repository.PropertyRepository;
import com.easyimmo.property.service.PropertyService;
import com.easyimmo.user.service.UserService;

@SpringBootTest
class PropertyServiceUTest {

    @Mock
    CustomValidator validator;

    @Mock
    UserService userService;

    @Mock
    PropertyRepository propertyRepository;

    @InjectMocks
    PropertyService propertyService;

    @BeforeEach
    void setUp() {
        SecurityContext securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(AuthenticationMock.getAuthenticationMock());
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void getByIdTest() {
        //Given
        Integer id = 1;
        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        Mockito.when(propertyRepository.findById(id)).thenReturn(Optional.of(new Property().userId(1)));
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
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        propertyService.getAll(propertyCriteria);
        //Then
        Mockito.verify(propertyRepository,Mockito.times(1)).findPropertyByMultipleCriteria(propertyCriteria);
    }

    @Test
    void updatePropertyTest() {
        //Given
        Property property = EntityBuilder.buildProperty("test").id(12312);
        Property propertyBody = new Property().name("uu").address("uu").buyPrice(1212310).rentType(Property.RentType.SHORT).type(Property.Type.HOUSE);
        Property updatedProperty = propertyBody.id(12312);
        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        Mockito.when(propertyRepository.findById(property.getId())).thenReturn(Optional.of(property));
        propertyService.updateProperty(property.getId(),propertyBody);
        //Then
        Mockito.verify(propertyRepository,Mockito.times(1)).save(updatedProperty);
    }

    @Test
    void addPropertyTest() {
        //Given
        Property property = EntityBuilder.buildProperty("test");
        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        propertyService.addProperty(property);
        //Then
        Mockito.verify(propertyRepository,Mockito.times(1)).save(property);
    }

    @Test
    void deleteByIdTest() {
        //Given
        Integer id = 1;
        Property property = EntityBuilder.buildProperty("test");
        //When
        Mockito.when(userService.getUserId("test")).thenReturn(1);
        Mockito.when(propertyRepository.findById(id)).thenReturn(Optional.of(property));
        propertyService.deleteById(id);
        //Then
        Mockito.verify(propertyRepository,Mockito.times(1)).delete(property);
    }
}
