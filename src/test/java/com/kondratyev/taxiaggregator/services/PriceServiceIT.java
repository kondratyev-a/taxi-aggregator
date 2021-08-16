package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PriceServiceIT {

    @Autowired
    PriceService priceService;

    final Long priceId = 2921215L;
    final int amount = 342;

    @Test
    void savePriceResponse() {

        PriceResponse priceRequest = new PriceResponse();

        priceRequest.setPrice(amount);
        priceRequest.setAggregatorId(15L);
        priceRequest.setPriceId(priceId);
        priceRequest.setFrom(new LocationResponse("55.035705,82.896254"));
        priceRequest.setTo(new LocationResponse("55.029283,82.926286"));
        priceRequest.setPriceLevel(1);

        PriceResponse priceResponse =  priceService.savePriceResponse(priceRequest);

        assertNotNull(priceResponse);
        assertEquals(priceId, priceResponse.getPriceId());
        assertEquals(amount, priceResponse.getPrice());

        Price price = priceService.findByPriceId(priceRequest.getPriceId());

        assertNotNull(price);
        assertEquals(priceId, price.getPriceId());
        assertEquals(amount, price.getPrice());

    }
}