package com.easyimmo.bankloan.dto;

public class BankLoanSummary {

    private Integer totalAmount;
    private Integer dueAmount;
    private Integer refundedAmount;

    public BankLoanSummary() {
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Integer dueAmount) {
        this.dueAmount = dueAmount;
    }

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    @Override
    public String toString() {
        return "BankLoanSummary{" +
                "totalAmount=" + totalAmount +
                ", dueAmount=" + dueAmount +
                ", refundedAmount=" + refundedAmount +
                '}';
    }
}
