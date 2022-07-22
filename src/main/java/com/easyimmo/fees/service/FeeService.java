package com.easyimmo.fees.service;

import com.easyimmo.common.exception.FeeNotFoundException;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.repository.FeeRepository;
import com.easyimmo.fees.util.UpdateFeeHelper;
import org.springframework.stereotype.Service;

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
}
