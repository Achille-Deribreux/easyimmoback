package com.easyimmo.bankloan.dto;

public class BankLoanSummary {

    private Integer totalAmount;
    private Integer dueAmount;
    private Integer refundedAmount;

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BankLoanSummary totalAmount(Integer totalAmount){
        setTotalAmount(totalAmount);
        return this;
    }

    public Integer getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Integer dueAmount) {
        this.dueAmount = dueAmount;
    }

    public BankLoanSummary dueAmount(Integer dueAmount){
        setDueAmount(dueAmount);
        return this;
    }

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public BankLoanSummary refundedAmount(Integer refundedAmount){
        setRefundedAmount(refundedAmount);
        return this;
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
