package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.CarResponseToCar;
import com.kondratyev.taxiaggregator.domain.Car;
import com.kondratyev.taxiaggregator.repositories.CarRepository;
import com.kondratyev.taxiaggregator.responses.CarResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarServiceImpl implements CarService {

    private final CarResponseToCar carResponseToCar;
    private final CarRepository carRepository;

    public CarServiceImpl(CarResponseToCar carResponseToCar, CarRepository carRepository) {
        this.carResponseToCar = carResponseToCar;
        this.carRepository = carRepository;
    }

    @Override
    public Car saveCarResponse(CarResponse carResponse) {
        Car convertedCar = carResponseToCar.convert(carResponse);

        if (convertedCar == null) {
            throw new IllegalArgumentException();
        }

        Car savedCar = carRepository.save(convertedCar);
        log.debug("Saved CarId: " + savedCar.getId());
        return savedCar;
    }
}
