package com.easyimmo.property.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyimmo.property.model.Property;

public interface PropertyRepository extends JpaRepository<Property, Integer>, CustomPropertyRepository {

    List<Property> findAllByType(Property.Type type);
}
