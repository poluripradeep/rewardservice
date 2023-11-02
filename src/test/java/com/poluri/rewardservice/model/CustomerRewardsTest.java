package com.poluri.rewardservice.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CustomerRewardsTest {

    @Test
    public void testCustomerRewardsBean() {
        CustomerRewards c = CustomerRewards.builder()
                .customerName("Test Name")
                .id(2)
                .build();
        Assert.assertEquals(c.getId(), 2);
        Assert.assertEquals(c.getCustomerName(), "Test Name");
    }

}