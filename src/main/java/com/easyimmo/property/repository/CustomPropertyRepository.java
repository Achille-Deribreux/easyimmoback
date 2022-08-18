package com.easyimmo.property.repository;

import java.util.List;

import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;

public interface CustomPropertyRepository {

    List<Property> findPropertyByMultipleCriteria(PropertyCriteria propertyCriteria);
}
