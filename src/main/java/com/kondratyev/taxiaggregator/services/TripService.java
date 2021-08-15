package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.Trip;
import com.kondratyev.taxiaggregator.responses.TripResponse;

public interface TripService {

    Trip findByTripId(Long id);

    TripResponse saveTripResponse (TripResponse tripResponse);

    void deleteById(Long id);

}
