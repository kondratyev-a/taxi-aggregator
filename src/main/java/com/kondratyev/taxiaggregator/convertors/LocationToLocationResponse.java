package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LocationToLocationResponse implements Converter<Location, LocationResponse> {
    @Override
    public LocationResponse convert(Location location) {

        LocationResponse locationResponse = new LocationResponse();
        locationResponse.setLocationId(location.getId());
        locationResponse.setLatitude(location.getLatitude());
        locationResponse.setLongitude(location.getLongitude());

        return locationResponse;
    }
}
