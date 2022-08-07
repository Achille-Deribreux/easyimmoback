package com.easyimmo.incomes.util;

import com.easyimmo.incomes.model.Income;
import com.easyimmo.property.model.Property;

import java.time.LocalDate;

public class UpdateIncomeHelper {

    private Income income;

    public UpdateIncomeHelper(Income income) {
        this.income = income;
    }

    public static UpdateIncomeHelper of (Income income){
        return new UpdateIncomeHelper(income);
    }

    public UpdateIncomeHelper property(Property property) {
        if (property != null && !property.equals(income.getProperty())) {
            income.setProperty(property);
        }
        return this;
    }

    public UpdateIncomeHelper description(String description) {
        if (description != null && !description.equals(income.getDescription())) {
            income.setDescription(description);
        }
        return this;
    }

    public UpdateIncomeHelper amount(Integer amount) {
        if (amount != null && !amount.equals(income.getAmount())) {
            income.setAmount(amount);
        }
        return this;
    }

    public UpdateIncomeHelper date(LocalDate date) {
        if (date != null && !date.equals(income.getDate())) {
            income.setDate(date);
        }
        return this;
    }

    public Income build(Income incomeBody) {
        this
                .property(incomeBody.getProperty())
                .amount(incomeBody.getAmount())
                .description(incomeBody.getDescription())
                .date(incomeBody.getDate());
        return income;
    }
}
