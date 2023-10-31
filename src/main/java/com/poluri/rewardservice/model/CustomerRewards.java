package com.poluri.rewardservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRewards {

    private int id;
    private String customerName;
    private Map<String, Long> rewardsByMonth;
}
