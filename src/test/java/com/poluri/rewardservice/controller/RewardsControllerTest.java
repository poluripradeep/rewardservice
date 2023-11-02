package com.poluri.rewardservice.controller;

import com.poluri.rewardservice.model.CustomerRewards;
import com.poluri.rewardservice.service.RewardsService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RewardsController.class)
public class RewardsControllerTest  {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RewardsService rewardsService;
    private String rewardsRequest;

    @BeforeEach
    void setUp() {
        rewardsRequest = createRewardsRequest();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void shouldGetRewardsForEachCustomer() throws Exception {
        when(rewardsService.getRewardsPerCustomer(Mockito.any())).thenReturn(createRewardsPerCustomerResponse());
        this.mockMvc.perform(post("/v1/rewards").content(rewardsRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("{\"Pradeep Poluri\":291,\"Pradeep Kumar\":309,\"Kumar Poluri\":417}"));
    }

    @Test
    public void shouldGetRewardsForEachCustomer_EmptyRequest() throws Exception {
        String input = "";
        when(rewardsService.getRewardsPerCustomer(Mockito.any())).thenReturn(createRewardsPerCustomerResponse());
        this.mockMvc.perform(post("/v1/rewards").content(input).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldGetRewardsForEachCustomerByMonth() throws Exception {
        List<CustomerRewards> response = createCustomerRewardsByMonthResponse();
        when(rewardsService.getRewardsPerCustomerPerMonth(Mockito.any())).thenReturn(response);
        this.mockMvc.perform(post("/v1/rewards/monthly").content(rewardsRequest).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("rewardsByMonth")));
    }

    @Test
    public void shouldGetRewardsForEachCustomerByMonth_EmptyRequest() throws Exception {
        String input = "";
        when(rewardsService.getRewardsPerCustomer(Mockito.any())).thenReturn(createRewardsPerCustomerResponse());
        this.mockMvc.perform(post("/v1/rewards/monthly").content(input).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    private Map<String, Long> createRewardsPerCustomerResponse() {
        Map<String, Long> rewardsPerCustomer = new HashMap<>();
        rewardsPerCustomer.put("Pradeep Poluri", Long.valueOf(291));
        rewardsPerCustomer.put("Pradeep Kumar", Long.valueOf(309));
        rewardsPerCustomer.put("Kumar Poluri", Long.valueOf(417));

        return rewardsPerCustomer;
    }

    private String createRewardsRequest() {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/test-data.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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