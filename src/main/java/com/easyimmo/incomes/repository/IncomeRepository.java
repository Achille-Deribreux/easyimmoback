package com.easyimmo.incomes.repository;

import com.easyimmo.incomes.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Income,Integer>, CustomIncomeRepository {
}
