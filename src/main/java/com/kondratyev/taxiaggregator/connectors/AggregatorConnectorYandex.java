package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.dummies.DummyObject;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AggregatorConnectorYandex implements AggregatorConnector {

    @Override
    public PriceResponse getPrice(Long userId, String fromLocation, String toLocation) {
        log.debug("get Yandex price. Here should be API call.");
        return DummyObject.getPriceResponse(fromLocation, toLocation);
    }

    @Override
    public TripResponse createTrip(CreateTripRequest createTripRequest) {
        return null;
    }


}