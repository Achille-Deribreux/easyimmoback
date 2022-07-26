package com.easyimmo.fees.service;

import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;

import java.time.LocalDate;
import java.util.List;

public interface IFeeService {
    //TODO Javadoc

    Fee getFeeById(Integer id);

    List<Fee> getAllFees(FeeCriteria feeCriteria);

    Fee addFee(Fee fee);

    Fee updateFee(Integer id, Fee fee);

    void deleteById(Integer id);

    Integer getTotalFeesFrom(Integer propertyId, LocalDate fromDate);

    List<Fee> getLastFees(Integer propertyId, Integer nbFees);
}
