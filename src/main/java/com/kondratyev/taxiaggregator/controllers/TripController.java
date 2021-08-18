package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.connectors.AggregatorRequest;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.requests.UpdateTripRequest;
import com.kondratyev.taxiaggregator.responses.DeleteTripResponse;
import com.kondratyev.taxiaggregator.responses.TripResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/trips")
public class TripController {

    private final AggregatorRequest aggregatorRequest;

    public TripController(AggregatorRequest aggregatorRequest) {
        this.aggregatorRequest = aggregatorRequest;
    }

    // Создание заказа
    @PostMapping
    Map<String, Object> createTrip(@RequestBody CreateTripRequest createTripRequest) {

        log.debug("Creating a trip");

        TripResponse result = null;
        String error = null;

        try {
            result = aggregatorRequest.createTrip(createTripRequest);
        }
        catch(Exception e) {
            error = e.getMessage();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("result", result);
        response.put("error", error);

        return response;
    }

    // Получение информации по заказу
    @GetMapping
    Map<String, Object> getTrip(@RequestParam(name = "user_id") Long userId,
                                @RequestParam(name = "trip_id") Long tripId) {

        log.debug("Getting info about the trip");

        Map<String, Object> response = new HashMap<>();
        response.put("result", "not implemented");
        response.put("error", null);

        return response;
    }

    // Обновление информации по заказу
    @PutMapping
    Map<String, Object> updateTrip(@RequestBody UpdateTripRequest updateTripRequest) {

        log.debug("Updating info about the trip");

        Map<String, Object> response = new HashMap<>();
        response.put("result", "not implemented");
        response.put("error", null);

        return response;
    }

    // Удаление заказа
    @DeleteMapping
    Map<String, Object> deleteTrip(@RequestBody DeleteTripRequest deleteTripRequest) {

        log.debug("Deleting the trip");

        DeleteTripResponse result = null;
        String error = null;

        try {
            result = aggregatorRequest.deleteTrip(deleteTripRequest);
        }
        catch(Exception e) {
            error = e.getMessage();
        }

        Map<String, Object> response = new HashMap<>();
        response.put("result", result);
        response.put("error", error);

        return response;
    }

}
