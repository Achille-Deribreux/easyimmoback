package com.easyimmo.bankloan.dto;

public class BankLoanSummary {

    private Long totalAmount;
    private Long dueAmount;
    private Long refundedAmount;

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BankLoanSummary totalAmount(Long totalAmount){
        setTotalAmount(totalAmount);
        return this;
    }

    public Long getDueAmount() {
        return dueAmount;
    }

    public void setDueAmount(Long dueAmount) {
        this.dueAmount = dueAmount;
    }

    public BankLoanSummary dueAmount(Long dueAmount){
        setDueAmount(dueAmount);
        return this;
    }

    public Long getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Long refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public BankLoanSummary refundedAmount(Long refundedAmount){
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
