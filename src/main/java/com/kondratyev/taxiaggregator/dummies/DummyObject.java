package com.kondratyev.taxiaggregator.dummies;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.responses.*;

import java.util.Random;

// Класс для имитации ответов от вызова методов агрегаторов
public class DummyObject {

    public static PriceResponse getPriceResponse(Long userId, Long aggregatorId,
                                                 String fromLocation, String toLocation) {

        PriceResponse dummyPrice = new PriceResponse();

        Random random = new Random();
        dummyPrice.setPrice(random.nextInt(300));
        dummyPrice.setUserId(userId);
        dummyPrice.setAggregatorId(aggregatorId);
        dummyPrice.setPriceId(2921215L);
        dummyPrice.setFrom(new LocationResponse(fromLocation));
        dummyPrice.setTo(new LocationResponse(toLocation));
        dummyPrice.setPriceLevel(1);

        return dummyPrice;
    }

    public static TripResponse getTripResponse(CreateTripRequest tripRequest, Price price) {
        TripResponse tripResponse = new TripResponse();

        tripResponse.setTripId(4000172L);
        tripResponse.setAggregatorId(price.getAggregatorId());
        tripResponse.setUserId(tripRequest.getUserId());
        tripResponse.setPriceId(tripRequest.getPriceId());
        tripResponse.setFrom(tripRequest.getFrom());
        tripResponse.setTo(tripRequest.getTo());
        tripResponse.setPrice(price.getPrice());

        DriverResponse driver = new DriverResponse();
        driver.setRating(4.52d);
        driver.setName("Эмильен");
        tripResponse.setDriver(driver);

        CarResponse car = new CarResponse();
        car.setCapacity(3);
        car.setModel("Skoda Octavia");
        tripResponse.setCar(car);

        return tripResponse;
    }

    public static DeleteTripResponse deleteTrip(DeleteTripRequest deleteTripRequest) {
        DeleteTripResponse deleteTripResponse = new DeleteTripResponse();
        deleteTripResponse.setTripId(deleteTripRequest.getTripId());
        return deleteTripResponse;
    }

}
