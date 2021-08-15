package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.dummies.DummyObject;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.responses.DeleteTripResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AggregatorConnectorYandex implements AggregatorConnector {

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public PriceResponse getPrice(Long userId, String fromLocation, String toLocation) {
        log.debug("get Yandex price");
        return DummyObject.getPriceResponse(getId(), fromLocation, toLocation);
    }

    @Override
    public TripResponse createTrip(CreateTripRequest createTripRequest, Price price) {
        log.debug("create Yandex trip");
        return DummyObject.getTripResponse(createTripRequest, price);
    }

    @Override
    public DeleteTripResponse deleteTrip(DeleteTripRequest deleteTripRequest) {
        log.debug("delete Yandex trip");
        return DummyObject.deleteTrip(deleteTripRequest);
    }


}