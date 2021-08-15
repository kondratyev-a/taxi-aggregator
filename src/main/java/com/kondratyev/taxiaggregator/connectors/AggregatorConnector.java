package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.responses.DeleteTripResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;

import java.util.concurrent.CompletableFuture;

public interface AggregatorConnector {

    Long getId();

    CompletableFuture<PriceResponse> getPrice(Long userId, String fromLocation, String toLocation);

    TripResponse createTrip(CreateTripRequest createTripRequest, Price price);

    DeleteTripResponse deleteTrip(DeleteTripRequest deleteTripRequest);

}
