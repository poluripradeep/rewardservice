package com.poluri.rewardservice.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class TransactionTest {

    @Test
    public void testTransactionBean() {
        Transaction t = Transaction.builder()
                .id(1)
                .purchaseAmount(400.00)
                .desc("Sample")
                .rewardPoints(0)
                .dateOfPurchase(LocalDateTime.now())
                .build();

        Assert.assertEquals(t.getId(), 1);
        Assert.assertEquals(t.getDesc(), "Sample");
        Assert.assertEquals(t.getRewardPoints().longValue(), 650);
    }
}