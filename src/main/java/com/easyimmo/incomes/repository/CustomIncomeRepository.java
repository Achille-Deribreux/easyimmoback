package com.easyimmo.incomes.repository;

import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;

import java.util.List;

public interface CustomIncomeRepository {

    List<Income> findIncomesByMultipleCriteria (IncomeCriteria incomeCriteria);
}
