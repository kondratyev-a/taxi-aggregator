package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Driver;
import com.kondratyev.taxiaggregator.repositories.DriverRepository;
import com.kondratyev.taxiaggregator.responses.DriverResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DriverResponseToDriver implements Converter<DriverResponse, Driver> {

    private final DriverRepository driverRepository;

    public DriverResponseToDriver(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver convert(DriverResponse driverResponse) {
        Driver driver = new Driver();
        driver.setRating(driverResponse.getRating());
        driver.setName(driverResponse.getName());

        Driver savedDriver = driverRepository.save(driver);
        log.debug("Saved DriverId: " + savedDriver.getId());

        return savedDriver;
    }
}
