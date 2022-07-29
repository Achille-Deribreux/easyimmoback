package com.easyimmo.fees.service;

import com.easyimmo.common.exception.FeeNotFoundException;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.repository.FeeRepository;
import com.easyimmo.fees.util.UpdateFeeHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeeService implements IFeeService{
    //TODO logs

    private final FeeRepository feeRepository;

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    @Override
    public Fee getFeeById(Integer id) {
        return feeRepository.findById(id).orElseThrow(()->new FeeNotFoundException(id.toString()));
    }

    @Override
    public List<Fee> getAllFees(FeeCriteria feeCriteria) {
        return feeRepository.findFeeByMultipleCriteria(feeCriteria);
    }

    @Override
    public Fee addFee(Fee fee) {
        return feeRepository.save(fee);
    }

    @Override
    public Fee updateFee(Integer id, Fee fee) {
        UpdateFeeHelper updateFeeHelper = UpdateFeeHelper.of(getFeeById(id));
        Fee updatedFee = updateFeeHelper.build(fee);
        return feeRepository.save(updatedFee);
    }

    @Override
    public void deleteById(Integer id) {
        Fee feeToDelete = getFeeById(id);
        feeRepository.delete(feeToDelete);
    }

    @Override
    public Integer getTotalFeesFrom(Integer propertyId, LocalDate fromDate) {
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).minDate(fromDate);
        List<Fee> feeList =feeRepository.findFeeByMultipleCriteria(feeCriteria);
        return feeList.stream().mapToInt(Fee::getAmount).sum();
    }

    public List<Fee> getLastFees(Integer propertyId, Integer nbFees) {
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).pageSize(nbFees);
        return feeRepository.findFeeByMultipleCriteria(feeCriteria);
    }
}
