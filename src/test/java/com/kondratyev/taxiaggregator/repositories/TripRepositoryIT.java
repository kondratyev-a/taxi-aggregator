package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Trip;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TripRepositoryIT {

    @Autowired
    TripRepository tripRepository;

    final Long tripId = 4000172L;

    @BeforeEach
    void setUp() {
        Trip trip = new Trip();
        trip.setTripId(tripId);
        tripRepository.save(trip);
    }

    @Test
    void findByTripId() {
        Optional<Trip> tripOptional = tripRepository.findByTripId(tripId);
        assertTrue(tripOptional.isPresent());
        assertEquals(tripId, tripOptional.get().getTripId());
    }
}