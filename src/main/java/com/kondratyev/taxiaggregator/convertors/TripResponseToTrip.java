package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Trip;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import com.kondratyev.taxiaggregator.services.CarService;
import com.kondratyev.taxiaggregator.services.DriverService;
import com.kondratyev.taxiaggregator.services.PriceService;
import com.kondratyev.taxiaggregator.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TripResponseToTrip implements Converter<TripResponse, Trip> {

    private final PriceService priceService;
    private final UserService userService;
    private final DriverService driverService;
    private final CarService carService;

    public TripResponseToTrip(PriceService priceService, UserService userService,
                              DriverService driverService, CarService carService) {
        this.priceService = priceService;
        this.userService = userService;
        this.driverService = driverService;
        this.carService = carService;
    }

    @Override
    public Trip convert(TripResponse tripResponse) {
        Trip trip = new Trip();

        trip.setTripId(tripResponse.getTripId());

        trip.setUser(userService.findById(tripResponse.getUserId()));

        trip.setPrice(priceService.findByPriceId(tripResponse.getPriceId()));

        trip.setCar(carService.saveCarResponse(tripResponse.getCar()));

        trip.setDriver(driverService.saveDriverResponse(tripResponse.getDriver()));

        return trip;
    }
}
