package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.domain.Trip;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TripToTripResponse implements Converter<Trip, TripResponse> {

    private final LocationToLocationResponse locationConverter;
    private final DriverToDriverResponse driverConverter;
    private final CarToCarResponse carConverter;

    public TripToTripResponse(LocationToLocationResponse locationConverter, DriverToDriverResponse driverConverter,
                              CarToCarResponse carConverter) {
        this.locationConverter = locationConverter;
        this.driverConverter = driverConverter;
        this.carConverter = carConverter;
    }

    @Override
    public TripResponse convert(Trip trip) {

        Price price = trip.getPrice();

        TripResponse tripResponse = new TripResponse();

        tripResponse.setUserId(trip.getUser().getId());
        tripResponse.setTripId(trip.getTripId());
        tripResponse.setAggregatorId(trip.getAggregatorId());
        tripResponse.setPriceId(price.getPriceId());
        tripResponse.setPrice(price.getPrice());
        tripResponse.setDriver(driverConverter.convert(trip.getDriver()));
        tripResponse.setCar(carConverter.convert(trip.getCar()));
        tripResponse.setFrom(locationConverter.convert(price.getFrom()));
        tripResponse.setTo(locationConverter.convert(price.getTo()));

        return tripResponse;
    }
}
