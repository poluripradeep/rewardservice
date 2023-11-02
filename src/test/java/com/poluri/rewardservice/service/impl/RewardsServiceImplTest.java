package com.poluri.rewardservice.service.impl;

import com.poluri.rewardservice.model.Customer;
import com.poluri.rewardservice.model.CustomerRewards;
import com.poluri.rewardservice.model.Transaction;
import com.poluri.rewardservice.service.RewardsService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.time.LocalDateTime;
import java.util.*;


class RewardsServiceImplTest {

    @Mock
    private RewardsService rewardsService;

    @BeforeEach
    void setup() {
        rewardsService = new RewardsServiceImpl();
    }

    @Test
    void getRewardsPerCustomer() {
        Map<String, Long> customerRewards = rewardsService.getRewardsPerCustomer(createRewardsRequest());
        Assert.assertNotNull(customerRewards);
        Assert.assertFalse(customerRewards.isEmpty());
        Assert.assertEquals(customerRewards.get("Pradeep Poluri").longValue(), 650);
    }

    @Test
    void getRewardsPerCustomerPerMonth() {
        List<CustomerRewards> rewardsPerCustomerPerMonth = rewardsService.getRewardsPerCustomerPerMonth(createRewardsRequest());
        Assert.assertNotNull(rewardsPerCustomerPerMonth);
        Assert.assertFalse(rewardsPerCustomerPerMonth.isEmpty());
        Assert.assertEquals(rewardsPerCustomerPerMonth.get(0).getRewardsByMonth().get("November").longValue(), 650);
    }

    private List<Customer> createRewardsRequest() {
        Customer c = Customer.builder()
                .id(1)
                .fullname("Pradeep Poluri")
                .transactions(
                        Arrays.asList(Transaction.builder().id(1).desc("Sample1").dateOfPurchase(LocalDateTime.now()).purchaseAmount(400.00).build())
                ).build();
        return Arrays.asList(c);
    }

    private List<CustomerRewards> createCustomerRewardsByMonthResponse() {
        List<CustomerRewards> customerRewardsList = new ArrayList<>();
        Map<String, Long> rewardsMap1 = new HashMap<>();
        rewardsMap1.put("September", Long.valueOf(252));
        rewardsMap1.put("July", Long.valueOf(19));
        rewardsMap1.put("August", Long.valueOf(25));
        Map<String, Long> rewardsMap2 = new HashMap<>();
        rewardsMap2.put("October", Long.valueOf(360));
        rewardsMap2.put("July", Long.valueOf(8));
        rewardsMap2.put("August", Long.valueOf(49));
        Map<String, Long> rewardsMap3 = new HashMap<>();
        rewardsMap3.put("September", Long.valueOf(50));
        rewardsMap3.put("October", Long.valueOf(53));
        rewardsMap3.put("August", Long.valueOf(206));
        customerRewardsList.add(CustomerRewards.builder().customerName("Pradeep Poluri").id(1).rewardsByMonth(rewardsMap1).build());
        customerRewardsList.add(CustomerRewards.builder().customerName("Kumar Poluri").id(2).rewardsByMonth(rewardsMap2).build());
        customerRewardsList.add(CustomerRewards.builder().customerName("Pradeep Kumar").id(3).rewardsByMonth(rewardsMap3).build());
        return customerRewardsList;
    }
}