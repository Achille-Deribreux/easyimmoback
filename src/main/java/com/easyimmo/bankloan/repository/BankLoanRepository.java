package com.easyimmo.bankloan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easyimmo.bankloan.model.Bankloan;
import com.easyimmo.property.model.Property;

public interface BankLoanRepository extends JpaRepository<Bankloan, Integer> {

    Optional<Bankloan> findBankloanByProperty(Property property);
}
