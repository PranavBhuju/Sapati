package com.sapati.a_common.entities;


import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.*;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
@MappedEntity(value = "BorrowRequests")

public class Borrow {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private  String borrowerName;
    @NonNull
    private Long requestedAmount;
    @NonNull
    private Long interestRate;
    @NonNull
    private Long payBackTime;
    private Long totalProfit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public Long getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(Long requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public Long getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Long interestRate) {
        this.interestRate = interestRate;
    }

    public Long getPayBackTime() {
        return payBackTime;
    }

    public void setPayBackTime(Long payBackTime) {
        this.payBackTime = payBackTime;
    }

    public Long getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(Long totalProfit) {
        this.totalProfit = totalProfit;
    }

    public Borrow(Long id, String borrowerName, Long requestedAmount, Long interestRate, Long payBackTime) {
        this.id = id;
        this.borrowerName = borrowerName;
        this.requestedAmount = requestedAmount;
        this.interestRate = interestRate;
        this.payBackTime = payBackTime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", borrowerName='" + borrowerName + '\'' +
                ", requestedAmount=" + requestedAmount +
                ", interestRate=" + interestRate +
                ", payBackTime=" + payBackTime +
                ", profit=" + totalProfit +
                '}';
    }
}
