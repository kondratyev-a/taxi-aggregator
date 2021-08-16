package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.connectors.AggregatorRequest;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PriceControllerTest {

    @Mock
    AggregatorRequest aggregatorRequest;

    PriceController controller;
    MockMvc mockMvc;

    public static final String LOCATION = "55.035705,82.896254";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        controller = new PriceController(aggregatorRequest);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void prices() throws Exception {

        when(aggregatorRequest.getPrice(anyLong(), anyString(), anyString()))
                .thenReturn(new PriceResponse());

        mockMvc.perform(get("/prices")
                        .param("user_id", "1863")
                        .param("start_place_point", LOCATION)
                        .param("finish_place_point", LOCATION))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.result", notNullValue()));
    }
}