package com.poluri.rewardservice.controller;

import com.poluri.rewardservice.model.Customer;
import com.poluri.rewardservice.model.CustomerRewards;
import com.poluri.rewardservice.service.RewardsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("v1/rewards")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @PostMapping
    public Map<String, Long> getRewards(@RequestBody List<Customer> customers) {
        log.info("Input:" + customers);

        return rewardsService.getRewardsPerCustomer(customers);
    }

    /**
     * Taking an input as list of customers with transactions is to avoid any database involvement
     *
     * @param customers
     * @return list of customerRewards objects
     */
    @PostMapping("/monthly")
    public List<CustomerRewards> getRewardsByMonth(@RequestBody List<Customer> customers) {
        log.info("getRewardsByMonth:" + customers);

        return rewardsService.getRewardsPerCustomerPerMonth(customers);
    }

    @PostMapping("/save")
    public boolean saveRewards(@RequestParam String customerId, @RequestParam Integer transactionAmount) {
        // TODO : Save a calculated reward per transaction if saved to DB
        return false;
    }

}
