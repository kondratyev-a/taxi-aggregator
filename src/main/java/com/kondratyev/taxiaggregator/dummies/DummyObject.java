package com.kondratyev.taxiaggregator.dummies;

import com.kondratyev.taxiaggregator.responses.LocationResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;

import java.util.Random;

// Класс для имитации ответов от вызова методов агрегаторов
public class DummyObject {

    public static PriceResponse getPriceResponse(String fromLocation, String toLocation) {

        PriceResponse dummyPrice = new PriceResponse();

        Random random = new Random();
        dummyPrice.setPrice(random.nextInt(300));
        dummyPrice.setFrom(new LocationResponse(fromLocation));
        dummyPrice.setTo(new LocationResponse(toLocation));
        dummyPrice.setPriceLevel(1);

        return dummyPrice;
    }

}
