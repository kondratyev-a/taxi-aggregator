package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.DriverResponseToDriver;
import com.kondratyev.taxiaggregator.domain.Driver;
import com.kondratyev.taxiaggregator.repositories.DriverRepository;
import com.kondratyev.taxiaggregator.responses.DriverResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public Driver saveDriverResponse(DriverResponse driverResponse) {

        Driver convertedDriver = driverResponseToDriver.convert(driverResponse);

        if (convertedDriver == null) {
            throw new IllegalArgumentException();
        }

        Driver savedDriver = driverRepository.save(convertedDriver);
        log.debug("Saved DriverId: " + savedDriver.getId());
        return savedDriver;
    }
}
