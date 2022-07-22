package com.easyimmo.incomes.service;

import com.easyimmo.common.exception.IncomeNotFoundException;
import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.repository.IncomeRepository;
import com.easyimmo.incomes.util.UpdateIncomeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncomeService implements IIncomeService{

    @Autowired
    private IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    public List<Income> getAllIncomes(IncomeCriteria incomeCriteria) {
        return incomeRepository.findIncomesByMultipleCriteria(incomeCriteria);
    }

    @Override
    public Income getIncomeById(Integer id) {
        return incomeRepository.findById(id).orElseThrow(()->new IncomeNotFoundException(id.toString()));
    }

    @Override
    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income updateIncome(Integer id, Income income) {
        UpdateIncomeHelper updateIncomeHelper = UpdateIncomeHelper.of(getIncomeById(id));
        Income updatedIncome = updateIncomeHelper.build(income);
        return incomeRepository.save(updatedIncome);
    }

    @Override
    public void deleteById(Integer id) {
        Income incomeToDelete = getIncomeById(id);
        incomeRepository.delete(incomeToDelete);
    }
}
