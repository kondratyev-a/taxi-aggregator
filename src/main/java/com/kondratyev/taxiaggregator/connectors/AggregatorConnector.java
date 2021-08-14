package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;

public interface AggregatorConnector {

    PriceResponse getPrice(Long userId, String fromLocation, String toLocation);

    TripResponse createTrip(CreateTripRequest createTripRequest);

}
