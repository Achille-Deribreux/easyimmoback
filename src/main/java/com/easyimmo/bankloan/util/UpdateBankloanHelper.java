package com.easyimmo.bankloan.util;

import java.time.LocalDate;

import com.easyimmo.bankloan.model.Bankloan;

public class UpdateBankloanHelper {

    private Bankloan bankloan;

    public UpdateBankloanHelper(Bankloan bankloan) {
        this.bankloan = bankloan;
    }

    public static UpdateBankloanHelper of(Bankloan bankloan){
        return new UpdateBankloanHelper(bankloan);
    }

    public UpdateBankloanHelper totalAmount (Integer totalAmount){
        if(totalAmount != null && !totalAmount.equals(bankloan.getTotalAmount())){
            bankloan.setTotalAmount(totalAmount);
        }
        return this;
    }

    public UpdateBankloanHelper monthlyPayment (Integer monthlyPayment){
        if(monthlyPayment != null && !monthlyPayment.equals(bankloan.getMonthlyPayment())){
            bankloan.setMonthlyPayment(monthlyPayment);
        }
        return this;
    }

    public UpdateBankloanHelper startDate (LocalDate startDate){
        if(startDate != null && !startDate.equals(bankloan.getStartDate())){
            bankloan.setStartDate(startDate);
        }
        return this;
    }

    public UpdateBankloanHelper endDate (LocalDate endDate){
        if(endDate != null && !endDate.equals(bankloan.getEndDate())){
            bankloan.setEndDate(endDate);
        }
        return this;
    }

    public Bankloan build(Bankloan bankloanBody){
        this
                .totalAmount(bankloanBody.getTotalAmount())
                .monthlyPayment(bankloanBody.getMonthlyPayment())
                .startDate(bankloanBody.getStartDate())
                .endDate(bankloanBody.getEndDate());
        return bankloan;
    }
}
