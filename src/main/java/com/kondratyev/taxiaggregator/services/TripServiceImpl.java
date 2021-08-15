package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.TripResponseToTrip;
import com.kondratyev.taxiaggregator.convertors.TripToTripResponse;
import com.kondratyev.taxiaggregator.domain.Trip;
import com.kondratyev.taxiaggregator.exceptions.TripNotFoundException;
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
    public Trip findByTripId(Long id) {
        Optional<Trip> tripOptional = tripRepository.findByTripId(id);
        if (tripOptional.isEmpty()) {
            throw new TripNotFoundException(id);
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

    @Override
    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }
}
