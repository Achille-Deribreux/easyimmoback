package com.easyimmo.fees.service;

import com.easyimmo.common.exception.FeeNotFoundException;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.repository.FeeRepository;
import com.easyimmo.fees.util.UpdateFeeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeeService implements IFeeService{

    private final FeeRepository feeRepository;

    private final Logger logger = LoggerFactory.getLogger(FeeService.class);

    public FeeService(FeeRepository feeRepository) {
        this.feeRepository = feeRepository;
    }

    @Override
    public Fee getFeeById(Integer id) {
        logger.info("searching fee with id : {}", id);
        return feeRepository.findById(id).orElseThrow(()->new FeeNotFoundException(id.toString()));
    }

    @Override
    public List<Fee> getAllFees(FeeCriteria feeCriteria) {
        logger.info("searching fees with criteria : {}", feeCriteria);
        return feeRepository.findFeeByMultipleCriteria(feeCriteria);
    }

    @Override
    public Fee addFee(Fee fee) {
        logger.info("adding fee : {}", fee);
        return feeRepository.save(fee);
    }

    @Override
    public Fee updateFee(Integer id, Fee fee) {
        UpdateFeeHelper updateFeeHelper = UpdateFeeHelper.of(getFeeById(id));
        Fee updatedFee = updateFeeHelper.build(fee);
        logger.info("updating fee : {}", updatedFee);
        return feeRepository.save(updatedFee);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("deleting fee with id : {}", id);
        Fee feeToDelete = getFeeById(id);
        feeRepository.delete(feeToDelete);
    }

    @Override
    public Integer getTotalFeesFrom(Integer propertyId, LocalDate fromDate) {
        logger.info("searching total fees from propertyId : {} and fromDate : {}", propertyId, fromDate);
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).minDate(fromDate);
        List<Fee> feeList =feeRepository.findFeeByMultipleCriteria(feeCriteria);
        return feeList.stream().mapToInt(Fee::getAmount).sum();
    }

    @Override
    public List<Fee> getLastFees(Integer propertyId, Integer nbFees) {
        logger.info("searching last fees from propertyId : {} and nbFees : {}", propertyId, nbFees);
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).pageSize(nbFees).pageNumber(1);
        return feeRepository.findFeeByMultipleCriteria(feeCriteria);
    }
}
