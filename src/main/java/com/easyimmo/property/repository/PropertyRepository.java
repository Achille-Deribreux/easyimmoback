package com.easyimmo.property.repository;

import com.easyimmo.property.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer>, CustomPropertyRepository {

    List<Property> findAllByType(Property.Type type);
}
