package com.easyimmo.incomes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easyimmo.incomes.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer>, CustomIncomeRepository {
}
