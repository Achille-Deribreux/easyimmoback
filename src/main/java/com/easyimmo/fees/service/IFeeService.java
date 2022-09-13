package com.easyimmo.fees.service;

import java.time.LocalDate;
import java.util.List;

import com.easyimmo.fees.dto.FeeCriteria;
import com.easyimmo.fees.model.Fee;

public interface IFeeService {

    /**
     * Method who search a fee by id
     * @param id the id of the fee to search
     * @return the fee found
     */
    Fee getFeeById(Integer id);

    /**
     * Method who search all fees with the given criteria
     * @param feeCriteria the criteria to search
     * @return the list of fees found
     */
    List<Fee> getAllFees(FeeCriteria feeCriteria);

    /**
     * Method who add a fee
     * @param fee the fee to add
     * @return the fee added
     */
    Fee addFee(Fee fee);

    /**
     * Method who update a fee
     * @param id the id of the fee to update
     * @param fee the new fee (only updated fields)
     * @return the fee updated
     */
    Fee updateFee(Integer id, Fee fee);

    /**
     * Method who delete a fee by id
     * @param id the id of the fee to delete
     */
    void deleteById(Integer id);

    /**
     * Method who search the total fees from a property
     * @param propertyId the id of the property
     * @param fromDate the date from which we want to search the total fees
     * @return the total fees
     */
    Integer getTotalFeesFrom(Integer propertyId, LocalDate fromDate);

    /**
     * Method who search the last fees from a property
     * @param propertyId the id of the property
     * @param nbFees the X last fees you want
     * @return the last fees
     */
    List<Fee> getLastFees(Integer propertyId, Integer nbFees);
}
