package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.Driver;
import com.kondratyev.taxiaggregator.responses.DriverResponse;

public interface DriverService {

    Driver saveDriverResponse (DriverResponse driverResponse);

}
