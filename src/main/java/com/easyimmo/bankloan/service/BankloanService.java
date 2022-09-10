package com.easyimmo.bankloan.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.easyimmo.bankloan.dto.BankLoanSummary;
import com.easyimmo.bankloan.model.Bankloan;
import com.easyimmo.bankloan.repository.BankLoanRepository;
import com.easyimmo.bankloan.util.UpdateBankloanHelper;
import com.easyimmo.common.exception.BankloanNotFoundException;
import com.easyimmo.common.utils.CustomValidator;
import com.easyimmo.property.model.Property;
import com.easyimmo.user.service.UserService;

@Service
public class BankloanService implements IBankloanService{

    private final Logger logger = LoggerFactory.getLogger(BankloanService.class);

    private final BankLoanRepository bankLoanRepository;

    private final UserService userService;

    private final CustomValidator customValidator;

    public BankloanService(BankLoanRepository bankLoanRepository, UserService userService, CustomValidator customValidator) {
        this.bankLoanRepository = bankLoanRepository;
        this.userService = userService;
        this.customValidator = customValidator;
    }

    @Override
    public Bankloan getById(Integer id) {
        logger.info("search in repository {}",id);
        Bankloan bankloan = bankLoanRepository.findById(id).orElseThrow(() -> new BankloanNotFoundException("id "+id));
        userService.checkUser(bankloan.getProperty().getUserId());
        return bankloan;
    }

    @Override
    public BankLoanSummary getBankLoanSummaryByProperty(Property property) {
        logger.info("get bankloan summary with property id {}",property.getId());
        Bankloan bankloan = bankLoanRepository.findBankloanByProperty(property).orElse(null);
        if(bankloan == null)
            return null;
        Integer months = bankloan.getEndDate().getMonthValue() - bankloan.getStartDate().getMonthValue();
        Integer refundedAmount = bankloan.getTotalAmount() - (bankloan.getMonthlyPayment() * months);
        Integer dueAmount = bankloan.getTotalAmount() - refundedAmount;
        return new BankLoanSummary()
                .totalAmount(bankloan.getTotalAmount())
                .refundedAmount(refundedAmount)
                .dueAmount(dueAmount);
    }

    @Override
    public Bankloan addBankloan(Bankloan bankloan) {
        customValidator.validate(bankloan);
        logger.info("add bankloan {}", bankloan);
        return bankLoanRepository.save(bankloan);
    }

    @Override
    public Bankloan updateBankloan(Integer id, Bankloan bankloanBody) {
        logger.info("update bankloan for bankloan id : {} and body {}", id, bankloanBody);
        UpdateBankloanHelper updateBankloanHelper = UpdateBankloanHelper.of(getById(id));
        Bankloan updatedBankloan = updateBankloanHelper.build(bankloanBody);
        return bankLoanRepository.save(updatedBankloan);
    }

    @Override
    public void deleteBankloan(Integer id) {
        logger.info("delete bankloan for id : {}", id);
        Bankloan bankloan = getById(id);
        bankLoanRepository.delete(bankloan);
    }
}
