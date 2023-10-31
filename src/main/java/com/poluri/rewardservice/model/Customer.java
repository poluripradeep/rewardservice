package com.poluri.rewardservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    private int id;
    private String fullname;
    private long rewards;
    private Double totalPurchaseAmount;
    private List<Transaction> transactions;

    public long getRewards() {
        if (null != transactions && !transactions.isEmpty()) {
            return transactions.stream().mapToLong(Transaction::getRewardPoints).sum();
        }
        return 0;
    }

    public Double getTotalPurchaseAmount() {
        if (null != transactions && !transactions.isEmpty()) {
            return transactions.stream().mapToDouble(Transaction::getPurchaseAmount).sum();
        }
        return 0.0;
    }

}
