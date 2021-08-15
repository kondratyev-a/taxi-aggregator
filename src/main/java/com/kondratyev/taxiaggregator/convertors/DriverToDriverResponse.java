package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Driver;
import com.kondratyev.taxiaggregator.responses.DriverResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DriverToDriverResponse  implements Converter<Driver, DriverResponse> {

    @Override
    public DriverResponse convert(Driver driver) {
        DriverResponse driverResponse = new DriverResponse();
        driverResponse.setRating(driver.getRating());
        driverResponse.setName(driver.getName());
        return driverResponse;
    }
}
