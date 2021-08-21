package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.connectors.AggregatorRequest;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.requests.UpdateTripRequest;
import com.kondratyev.taxiaggregator.responses.DeleteTripResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/trips")
public class TripController {

    private final AggregatorRequest aggregatorRequest;

    public TripController(AggregatorRequest aggregatorRequest) {
        this.aggregatorRequest = aggregatorRequest;
    }

    @PostMapping
    ResponseEntity<TripResponse> createTrip(@RequestBody CreateTripRequest createTripRequest) {

        log.debug("Creating a trip");
        return ResponseEntity.ok(aggregatorRequest.createTrip(createTripRequest));
    }

    @GetMapping
    ResponseEntity<TripResponse> getTrip(@RequestParam(name = "user_id") Long userId,
                                         @RequestParam(name = "trip_id") Long tripId) {

        log.debug("Getting info about the trip");
        return ResponseEntity.ok(new TripResponse());
    }

    @PutMapping
    ResponseEntity<TripResponse> updateTrip(@RequestBody UpdateTripRequest updateTripRequest) {

        log.debug("Updating info about the trip");
        return ResponseEntity.ok(new TripResponse());
    }

    @DeleteMapping
    ResponseEntity<DeleteTripResponse> deleteTrip(@RequestBody DeleteTripRequest deleteTripRequest) {

        log.debug("Deleting the trip");
        return ResponseEntity.ok(aggregatorRequest.deleteTrip(deleteTripRequest));
    }

}
