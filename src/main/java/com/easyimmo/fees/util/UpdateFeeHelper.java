package com.easyimmo.fees.util;

import com.easyimmo.fees.model.Fee;
import com.easyimmo.property.model.Property;

import java.time.LocalDate;

public class UpdateFeeHelper {

    private Fee fee;

    public UpdateFeeHelper(Fee fee) {
        this.fee = fee;
    }

    public static UpdateFeeHelper of(Fee fee) {
        return new UpdateFeeHelper(fee);
    }

    public UpdateFeeHelper property(Property property) {
        if (property != null && !property.equals(fee.getProperty())) {
            fee.setProperty(property);
        }
        return this;
    }

    public UpdateFeeHelper supplier(String supplier) {
        if (supplier != null && !supplier.equals(fee.getSupplier())) {
            fee.setSupplier(supplier);
        }
        return this;
    }

    public UpdateFeeHelper description(String description) {
        if (description != null && !description.equals(fee.getDescription())) {
            fee.setDescription(description);
        }
        return this;
    }

    public UpdateFeeHelper amount(Integer amount) {
        if (amount != null && !amount.equals(fee.getAmount())) {
            fee.setAmount(amount);
        }
        return this;
    }

    public UpdateFeeHelper date(LocalDate date) {
        if (date != null && !date.equals(fee.getDate())) {
            fee.setDate(date);
        }
        return this;
    }

    public Fee build(Fee fee) {
        this
            .property(fee.getProperty())
            .amount(fee.getAmount())
            .supplier(fee.getSupplier())
            .description(fee.getDescription())
            .date(fee.getDate());
        return fee;
    }


}
