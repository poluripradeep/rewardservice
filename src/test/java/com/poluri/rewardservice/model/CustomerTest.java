package com.poluri.rewardservice.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

class CustomerTest {

    @Test
    public void testCustomerBean() {
        Customer c = Customer.builder()
                .id(1)
                .rewards(20)
                .fullname("Test Name")
                .transactions(Arrays.asList(Transaction.builder().id(1).desc("TestTrans").dateOfPurchase(LocalDateTime.now()).build()))
                .build();
        Assert.assertEquals(c.getId(), 1);
        Assert.assertEquals(c.getFullname(), "Test Name");
        Assert.assertEquals(c.getTransactions().get(0).getDesc(), "TestTrans");
    }
}