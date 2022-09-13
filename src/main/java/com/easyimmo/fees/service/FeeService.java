package com.easyimmo.fees.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.easyimmo.common.exception.FeeNotFoundException;
import com.easyimmo.common.utils.CurrentUser;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;
import com.easyimmo.fees.repository.FeeRepository;
import com.easyimmo.fees.util.UpdateFeeHelper;
import com.easyimmo.user.service.UserService;

@Service
public class FeeService implements IFeeService{

    private final FeeRepository feeRepository;

    private final Logger logger = LoggerFactory.getLogger(FeeService.class);

    private final CustomValidator validator;

    private final UserService userService;

    public FeeService(FeeRepository feeRepository, CustomValidator validator, UserService userService) {
        this.feeRepository = feeRepository;
        this.validator = validator;
        this.userService = userService;
    }

    @Override
    public Fee getFeeById(Integer id) {
        logger.info("searching fee with id : {}", id);
        Fee fee =  feeRepository.findById(id).orElseThrow(()->new FeeNotFoundException(id.toString()));
        userService.checkUser(fee.getProperty().getUserId());
        return fee;
    }

    @Override
    public List<Fee> getAllFees(FeeCriteria feeCriteria) {
        logger.info("searching fees with criteria : {}", feeCriteria);
        feeCriteria.userId(userService.getUserId(CurrentUser.getCurrentUserName()));
        return feeRepository.findFeeByMultipleCriteria(feeCriteria);
    }

    @Override
    public Fee addFee(Fee fee) {
        validator.validate(fee);
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
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).minDate(fromDate).userId(userService.getUserId(CurrentUser.getCurrentUserName()));
        List<Fee> feeList =feeRepository.findFeeByMultipleCriteria(feeCriteria);
        return feeList.stream().mapToInt(Fee::getAmount).sum();
    }

    @Override
    public List<Fee> getLastFees(Integer propertyId, Integer nbFees) {
        logger.info("searching last fees from propertyId : {} and nbFees : {}", propertyId, nbFees);
        FeeCriteria feeCriteria = new FeeCriteria().propertyId(propertyId).pageSize(nbFees).pageNumber(1).userId(userService.getUserId(CurrentUser.getCurrentUserName()));
        return feeRepository.findFeeByMultipleCriteria(feeCriteria);
    }
}
