package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.responses.LocationResponse;

public interface LocationService {

    Location saveLocationResponse (LocationResponse locationResponse);
}
