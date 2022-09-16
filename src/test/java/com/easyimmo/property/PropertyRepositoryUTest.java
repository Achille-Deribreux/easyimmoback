package com.easyimmo.property;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;
import com.easyimmo.property.repository.PropertyRepository;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PropertyRepositoryUTest {

    @Autowired
    PropertyRepository propertyRepository;

    Property property1 = new Property()
            .id(1)
            .userId(1)
            .name("property 1")
            .address("address 1")
            .buyPrice(100)
            .rentType(Property.RentType.SHORT)
            .type(Property.Type.APPARTMENT);

    Property property2 = new Property()
            .id(2)
            .userId(2)
            .name("property 2")
            .address("address 2")
            .buyPrice(200)
            .rentType(Property.RentType.LONG)
            .type(Property.Type.HOUSE);

    Property property3 = new Property()
            .id(3)
            .userId(3)
            .name("property 3")
            .address("address 3")
            .buyPrice(300)
            .rentType(Property.RentType.SHORT)
            .type(Property.Type.HOUSE);

    @BeforeEach
    void setUp() {
        propertyRepository.save(property1);
        propertyRepository.save(property2);
        propertyRepository.save(property3);
    }

    @Test
    @DisplayName("try to find a property based on it's name")
    void findByNameTest() {
        //Given
        PropertyCriteria criteria = new PropertyCriteria()
                .name("1");
        List<Property> expected = List.of(property1);
        //When
        List<Property> result = propertyRepository.findPropertyByMultipleCriteria(criteria);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0),result.get(0));
    }

    @Test
    @DisplayName("try to find a property based on it's type")
    void findByTypeTest() {
        //Given
        PropertyCriteria criteria = new PropertyCriteria()
                .type(Property.Type.APPARTMENT);
        List<Property> expected = List.of(property1);
        //When
        List<Property> result = propertyRepository.findPropertyByMultipleCriteria(criteria);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0),result.get(0));
    }

    @Test
    @DisplayName("try to find a property based on a price range")
    void findByPriceTest() {
        //Given
        PropertyCriteria criteria = new PropertyCriteria()
                .lowPrice(150)
                .highPrice(250);
        List<Property> expected = List.of(property2);
        //When
        List<Property> result = propertyRepository.findPropertyByMultipleCriteria(criteria);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0),result.get(0));
    }

    @Test
    @DisplayName("try to find a property based on a userId")
    void findByUserTest() {
        //Given
        PropertyCriteria criteria = new PropertyCriteria()
                .userId(2);
        List<Property> expected = List.of(property2);
        //When
        List<Property> result = propertyRepository.findPropertyByMultipleCriteria(criteria);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0),result.get(0));
    }

    @Test
    @DisplayName("test that properties are ordered by buyPrice desc")
    void orderByTest() {
        //Given
        PropertyCriteria criteria = new PropertyCriteria();
        List<Property> expected = List.of(property3,property2,property1);
        //When
        List<Property> result = propertyRepository.findPropertyByMultipleCriteria(criteria);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0),result.get(0));
    }

    @Test
    @DisplayName("paging test")
    void pagingTest() {
        //Given
        PropertyCriteria criteria = new PropertyCriteria()
                .pageNumber(1)
                .pageSize(1);
        List<Property> expected = List.of(property3);
        //When
        List<Property> result = propertyRepository.findPropertyByMultipleCriteria(criteria);
        //Then
        Assertions.assertEquals(expected.size(),result.size());
        Assertions.assertEquals(expected.get(0),result.get(0));
    }
}
