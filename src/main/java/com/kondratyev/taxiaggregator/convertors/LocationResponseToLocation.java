package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationResponseToLocation implements Converter<LocationResponse, Location> {

    @Override
    public Location convert(LocationResponse locationResponse) {

        Location location = new Location();
        location.setLatitude(locationResponse.getLatitude());
        location.setLongitude(locationResponse.getLongitude());

        return location;
    }
}
