package com.easyimmo.fees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyimmo.fees.model.Fee;

public interface FeeRepository extends JpaRepository<Fee, Integer>, CustomFeeRepository {
    List<Fee> findAllByPropertyId(Integer propertyId);
}
