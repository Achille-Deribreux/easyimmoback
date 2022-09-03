package com.easyimmo.bankloan.service;

import com.easyimmo.bankloan.dto.BankLoanSummary;
import com.easyimmo.bankloan.model.Bankloan;

public interface IBankloanService {

    Bankloan getById(Integer id);

    BankLoanSummary getBankLoanSummaryById(Integer id);

    Bankloan addBankloan(Bankloan bankloan);

    Bankloan updateBankloan(Integer id, Bankloan bankloanBody);

    void deleteBankloan(Bankloan bankloan);
}
