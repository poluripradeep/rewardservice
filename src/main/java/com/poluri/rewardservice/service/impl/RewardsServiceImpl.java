package com.poluri.rewardservice.service.impl;

import com.poluri.rewardservice.model.Customer;
import com.poluri.rewardservice.model.CustomerRewards;
import com.poluri.rewardservice.model.Transaction;
import com.poluri.rewardservice.service.RewardsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RewardsServiceImpl implements RewardsService {
    @Override
    public void saveRewards(int transactionAmount) {
        int rewards = 0;
        if (transactionAmount > 100) {
            rewards = rewards + (transactionAmount - 100) * 2 + 50;
        } else if (transactionAmount >= 50 && transactionAmount <= 100) {
            rewards = transactionAmount * 1;
        }
    }

    @Override
    public Map<String, Long> getRewardsPerCustomer(List<Customer> customers) {
        return customers.stream().collect(Collectors.toMap(Customer::getFullname, Customer::getRewards));
    }

    public List<CustomerRewards> getRewardsPerCustomerPerMonth(List<Customer> customers) {
        List<CustomerRewards> customerRewardResponses = new ArrayList<>();
        customers.forEach(c -> {
            CustomerRewards customerRewards = new CustomerRewards();
            customerRewards.setId(c.getId());
            customerRewards.setCustomerName(c.getFullname());
            Map<String, Long> monthToRewards = new HashMap<>();
            c.getTransactions().forEach(t -> {
                String month = t.getDateOfPurchase().getMonth().getDisplayName(TextStyle.FULL, Locale.US);
                long totalRewards = t.getRewardPoints();
                if (monthToRewards.containsKey(month)) {
                    totalRewards = monthToRewards.get(month) + t.getRewardPoints();
                }
                monthToRewards.put(month, totalRewards);
            });
            customerRewards.setRewardsByMonth(monthToRewards);
            customerRewardResponses.add(customerRewards);
        });
        return customerRewardResponses;
    }


}
