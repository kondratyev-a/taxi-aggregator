package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.LocationResponseToLocation;
import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.repositories.LocationRepository;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;
    private final LocationResponseToLocation locationResponseToLocation;

    public LocationServiceImpl(LocationRepository locationRepository, LocationResponseToLocation locationResponseToLocation) {
        this.locationRepository = locationRepository;
        this.locationResponseToLocation = locationResponseToLocation;
    }

    @Override
    public Location saveLocationResponse(LocationResponse locationResponse) {
        if (locationResponse == null) {
            return null;
        }
        Location convertedLocation = locationResponseToLocation.convert(locationResponse);

        Location savedLocation = locationRepository.save(convertedLocation);
        log.debug("Saved LocationId: " + savedLocation.getId());
        return savedLocation;
    }
}
