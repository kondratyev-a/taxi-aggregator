package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Car;
import com.kondratyev.taxiaggregator.responses.CarResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarToCarResponse implements Converter<Car, CarResponse> {
    @Override
    public CarResponse convert(Car car) {
        CarResponse carResponse = new CarResponse();
        carResponse.setModel(car.getModel());
        carResponse.setCapacity(car.getCapacity());
        return carResponse;
    }
}
