package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.Trip;
import com.kondratyev.taxiaggregator.responses.TripResponse;

public interface TripService {

    Trip findById(Long id);

    TripResponse saveTripResponse (TripResponse tripResponse);

}
