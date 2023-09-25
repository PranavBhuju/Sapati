package com.sapati.a_common.entities;

import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

import java.sql.Time;
import java.sql.Timestamp;

@Serdeable
@MappedEntity(value = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private Long transactionId;
    private String lenderName;
    private String borrowerName;
    private Long loan;
    @DateCreated
    private Timestamp transactionDate;
    @DateUpdated
    private Timestamp transactionCompletedDate;
    private String paymentStatus;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getLenderName() {
        return lenderName;
    }

    public void setLenderName(String lenderName) {
        this.lenderName = lenderName;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Long getLoan() {
        return loan;
    }

    public void setLoan(Long loan) {
        this.loan = loan;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Timestamp getTransactionCompletedDate() {
        return transactionCompletedDate;
    }

    public void setTransactionCompletedDate(Timestamp transactionCompletedDate) {
        this.transactionCompletedDate = transactionCompletedDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Transaction( String lenderName, String borrowerName, Long loan) {
        this.lenderName = lenderName;
        this.borrowerName = borrowerName;
        this.loan = loan;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", lenderName='" + lenderName + '\'' +
                ", borrowerName='" + borrowerName + '\'' +
                ", loan=" + loan +
                ", transactionDate=" + transactionDate +
                ", transactionCompletedDate=" + transactionCompletedDate +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}