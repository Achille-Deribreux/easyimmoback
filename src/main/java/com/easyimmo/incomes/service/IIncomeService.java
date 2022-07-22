package com.easyimmo.incomes.service;

import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;

import java.util.List;

public interface IIncomeService {

    List<Income> getAllIncomes(IncomeCriteria incomeCriteria);

    Income getIncomeById(Integer id);

    Income addIncome(Income income);

    Income updateIncome(Integer id,Income income);

    void deleteById(Integer id);
}
