package com.easyimmo.fees.repository;

import java.util.List;

import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;

public interface CustomFeeRepository {
    List<Fee> findFeeByMultipleCriteria(FeeCriteria feeCriteria);
}
