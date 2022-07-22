package com.easyimmo.fees.repository;

import com.easyimmo.fees.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeeRepository extends JpaRepository<Fee, Integer>, CustomFeeRepository {
    List<Fee> findAllByPropertyId(Integer propertyId);
}
