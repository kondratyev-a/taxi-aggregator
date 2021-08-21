package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.responses.DeleteTripResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;

public interface AggregatorRequest {

    PriceResponse getPrice(Long userId, String fromLocation, String toLocation);

    TripResponse createTrip(CreateTripRequest tripRequest);

    DeleteTripResponse deleteTrip(DeleteTripRequest deleteTripRequest);
}
