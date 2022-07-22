package com.easyimmo.fees.repository;

import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;

import java.util.List;

public interface CustomFeeRepository {
    List<Fee> findFeeByMultipleCriteria(FeeCriteria feeCriteria);
}
