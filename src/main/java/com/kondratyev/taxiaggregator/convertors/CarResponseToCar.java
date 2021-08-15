package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Car;
import com.kondratyev.taxiaggregator.repositories.CarRepository;
import com.kondratyev.taxiaggregator.responses.CarResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CarResponseToCar implements Converter<CarResponse, Car> {

    private final CarRepository carRepository;

    public CarResponseToCar(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car convert(CarResponse carResponse) {

        Car car = new Car();

        car.setCapacity(carResponse.getCapacity());
        car.setModel(carResponse.getModel());

        return car;
    }
}
