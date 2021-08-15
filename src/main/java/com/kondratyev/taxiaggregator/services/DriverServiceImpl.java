package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.DriverResponseToDriver;
import com.kondratyev.taxiaggregator.domain.Driver;
import com.kondratyev.taxiaggregator.repositories.DriverRepository;
import com.kondratyev.taxiaggregator.responses.DriverResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final DriverResponseToDriver driverResponseToDriver;

    public DriverServiceImpl(DriverRepository driverRepository, DriverResponseToDriver driverResponseToDriver) {
        this.driverRepository = driverRepository;
        this.driverResponseToDriver = driverResponseToDriver;
    }

    @Override
    public Driver saveDriverResponse(DriverResponse driverResponse) {
        Driver convertedDriver = driverResponseToDriver.convert(driverResponse);

        Driver savedDriver = driverRepository.save(convertedDriver);
        log.debug("Saved DriverId: " + savedDriver.getId());
        return savedDriver;
    }
}
