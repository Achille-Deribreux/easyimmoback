package com.easyimmo.bankloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyimmo.bankloan.model.Bankloan;

public interface BankLoanRepository extends JpaRepository<Bankloan, Integer> {
}
