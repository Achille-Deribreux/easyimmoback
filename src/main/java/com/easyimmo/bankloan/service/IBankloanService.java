package com.easyimmo.bankloan.service;

import com.easyimmo.bankloan.dto.BankLoanSummary;
import com.easyimmo.bankloan.model.Bankloan;
import com.easyimmo.property.model.Property;

public interface IBankloanService {

    /**
     * Method which search the bankloan by id and throws an exception if not found
     * @param id of the bankloan you want
     * @return wanted bankloan
     */
    Bankloan getById(Integer id);

    /**
     * Method which search the bankloan by property id and throws an exception if not found
     * @param id of the property of the bankloan you want
     * @return wanted bankloan in a summary dto format
     */
    BankLoanSummary getBankLoanSummaryByProperty(Property property);

    /**
     * Method which add a bankloan
     * @param bankloan bankloan to add
     * @return added bankoan
     */
    Bankloan addBankloan(Bankloan bankloan);

    /**
     * Method which updates a bankloan
     * @param id original bankloan id
     * @param bankloanBody bankloan object with the fields you want to update
     * @return updated bankloan
     */
    Bankloan updateBankloan(Integer id, Bankloan bankloanBody);

    /**
     * Method which deletes a bankloan
     * @param id of the bankloan you want to delete
     */
    void deleteBankloan(Integer id);
}
