package com.sapati.c_transaction.c_lenderSendMoney;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@Introspected
public class LenderAccept {

    private String borrowerName;
    private Long lendingAmount;

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Long getLendingAmount() {
        return lendingAmount;
    }

    public void setLendingAmount(Long lendingAmount) {
        this.lendingAmount = lendingAmount;
    }

    public LenderAccept(String borrowerName, Long lendingAmount) {
        this.borrowerName = borrowerName;
        this.lendingAmount = lendingAmount;
    }

    @Override
    public String toString() {
        return "LenderAccept{" +
                "borrowerName='" + borrowerName + '\'' +
                ", lendingAmount=" + lendingAmount +
                '}';
    }
}
