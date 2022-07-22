package com.easyimmo.property.repository;

import com.easyimmo.property.dto.PropertyCriteria;
import com.easyimmo.property.model.Property;

import java.util.List;

public interface CustomPropertyRepository {

    List<Property> findPropertyByMultipleCriteria(PropertyCriteria propertyCriteria);
}
