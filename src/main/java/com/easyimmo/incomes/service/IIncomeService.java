package com.easyimmo.incomes.service;

import java.time.LocalDate;
import java.util.List;

import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;

public interface IIncomeService {

    /**
     * This method search for all the incomes, based on a given criteria
     * @param incomeCriteria criteria that you want to use to search for incomes
     * @return list of all the incomes
     */
    List<Income> getAllIncomes(IncomeCriteria incomeCriteria);

    /**
     * This method search for an income, based on a given id
     * @param id id of the income that you search
     * @return the wanted income
     */
    Income getIncomeById(Integer id);

    /**
     * This method allows you to add an income
     * @param income income that you want to add
     * @return the added income
     */
    Income addIncome(Income income);



    /**
     * This method allows you to update an income
     * @param id id of the income that you want to update
     * @param income income that you want to update
     * @return the updated income
     */
    Income updateIncome(Integer id,Income income);

    /**
     * This method allows you to delete an income, for a given id
     * @param id id of the income that you want to delete
     */
    void deleteById(Integer id);

    /**
     * This method calculates the total incomes from a given property, from a given date
     * @param propertyId id of the property that you want to calculate the total incomes from
     * @param fromDate date from which you want to calculate the total incomes
     * @return the total incomes from a given property, from a given date
     */
    Integer getTotalIncomesFrom(Integer propertyId, LocalDate fromDate);

    /**
     * This method returns the last X incomes from a given property
     * @param propertyId id of the property that you want to get the last X incomes from
     * @param nbIncomes number of incomes that you want to get
     * @return the last X incomes from a given property
     */
    List<Income> getLastIncomes(Integer propertyId, Integer nbIncomes);
}
