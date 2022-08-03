package com.easyimmo.incomes.service;

import com.easyimmo.common.exception.IncomeNotFoundException;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.incomes.dto.IncomeCriteria;
import com.easyimmo.incomes.model.Income;
import com.easyimmo.incomes.repository.IncomeRepository;
import com.easyimmo.incomes.util.UpdateIncomeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeService implements IIncomeService{

    private final Logger logger = LoggerFactory.getLogger(IncomeService.class);

    private final IncomeRepository incomeRepository;

    private final CustomValidator validator;

    public IncomeService(IncomeRepository incomeRepository, CustomValidator validator) {
        this.incomeRepository = incomeRepository;
        this.validator = validator;
    }

    @Override
    public List<Income> getAllIncomes(IncomeCriteria incomeCriteria) {
        logger.info("get all incomes from repository with criteria {}",incomeCriteria);
        return incomeRepository.findIncomesByMultipleCriteria(incomeCriteria);
    }

    @Override
    public Income getIncomeById(Integer id) {
        logger.info("search in repository {}",id);
        return incomeRepository.findById(id).orElseThrow(()->new IncomeNotFoundException(id.toString()));
    }

    @Override
    public Income addIncome(Income income) {
        validator.validate(income);
        logger.info("add income to repository {}",income);
        return incomeRepository.save(income);
    }

    @Override
    public Income updateIncome(Integer id, Income income) {
        logger.info("update income for income id : {}", id);
        UpdateIncomeHelper updateIncomeHelper = UpdateIncomeHelper.of(getIncomeById(id));
        Income updatedIncome = updateIncomeHelper.build(income);
        return incomeRepository.save(updatedIncome);
    }

    @Override
    public void deleteById(Integer id) {
        logger.info("delete income from repository {}",id);
        Income incomeToDelete = getIncomeById(id);
        incomeRepository.delete(incomeToDelete);
    }

    @Override
    public Integer getTotalIncomesFrom(Integer propertyId, LocalDate fromDate) {
        logger.info("get total incomes from property {} from date {}",propertyId,fromDate);
        IncomeCriteria incomeCriteria = new IncomeCriteria().propertyId(propertyId).minDate(fromDate);
        List<Income> incomeList =incomeRepository.findIncomesByMultipleCriteria(incomeCriteria);
        return incomeList.stream().mapToInt(Income::getAmount).sum();
    }

    @Override
    public List<Income> getLastIncomes(Integer propertyId, Integer nbIncomes) {
        logger.info("get last incomes from property {}",propertyId);
        IncomeCriteria incomeCriteria = new IncomeCriteria().propertyId(propertyId).pageSize(nbIncomes).pageNumber(1);
        return incomeRepository.findIncomesByMultipleCriteria(incomeCriteria);
    }
}
