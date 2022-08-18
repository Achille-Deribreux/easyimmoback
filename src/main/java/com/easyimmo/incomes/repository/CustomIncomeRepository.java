package com.easyimmo.incomes.repository;

import java.util.List;

import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;

public interface CustomIncomeRepository {

    List<Income> findIncomesByMultipleCriteria (IncomeCriteria incomeCriteria);
}
