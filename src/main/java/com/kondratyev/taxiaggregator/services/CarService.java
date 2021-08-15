package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.Car;
import com.kondratyev.taxiaggregator.responses.CarResponse;

public interface CarService {

    Car saveCarResponse (CarResponse carResponse);
}
