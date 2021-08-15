package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.TripResponseToTrip;
import com.kondratyev.taxiaggregator.convertors.TripToTripResponse;
import com.kondratyev.taxiaggregator.domain.Trip;
import com.kondratyev.taxiaggregator.repositories.TripRepository;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final TripResponseToTrip tripResponseToTrip;
    private final TripToTripResponse tripToTripResponse;

    public TripServiceImpl(TripRepository tripRepository, TripResponseToTrip tripResponseToTrip,
                           TripToTripResponse tripToTripResponse) {
        this.tripRepository = tripRepository;
        this.tripResponseToTrip = tripResponseToTrip;
        this.tripToTripResponse = tripToTripResponse;
    }

    @Override
    public Trip findById(Long id) {
        Optional<Trip> tripOptional = tripRepository.findById(id);
        if (tripOptional.isEmpty()) {
            throw new RuntimeException("Trip not found");
        }
        return tripOptional.get();
    }

    @Override
    public TripResponse saveTripResponse(TripResponse tripResponse) {
        Trip convertedTrip = tripResponseToTrip.convert(tripResponse);

        Trip savedTrip = tripRepository.save(convertedTrip);
        log.debug("Saved TripId: " + savedTrip.getId());
        return tripToTripResponse.convert(savedTrip);
    }
}
