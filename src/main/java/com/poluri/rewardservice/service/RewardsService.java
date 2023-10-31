package com.poluri.rewardservice.service;

import com.poluri.rewardservice.model.Customer;
import com.poluri.rewardservice.model.CustomerRewards;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface RewardsService {

    public void saveRewards(int transactionAmount);

    public Map<String, Long> getRewardsPerCustomer(List<Customer> customers);

    public List<CustomerRewards> getRewardsPerCustomerPerMonth(List<Customer> customers);
}
