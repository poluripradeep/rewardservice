package com.poluri.rewardservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    private int id;
    private String desc;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private LocalDateTime dateOfPurchase;
    private long rewardPoints;
    private Double purchaseAmount;

    public Long getRewardPoints() {
        rewardPoints = 0;
        if (purchaseAmount > 50 && purchaseAmount <= 100) {
            rewardPoints += (purchaseAmount.intValue() - 50) * 1;
        }
        if (purchaseAmount > 100) {
            rewardPoints += 50;
            rewardPoints += (purchaseAmount.intValue() - 100) * 2;
        }
        return rewardPoints;
    }
}
