package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.connectors.AggregatorRequest;
import com.kondratyev.taxiaggregator.requests.CreateTripRequest;
import com.kondratyev.taxiaggregator.requests.DeleteTripRequest;
import com.kondratyev.taxiaggregator.requests.UpdateTripRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class TripController {

    private final AggregatorRequest aggregatorRequest;

    public TripController(AggregatorRequest aggregatorRequest) {
        this.aggregatorRequest = aggregatorRequest;
    }

    // Создание заказа
    @PostMapping("/trips")
    Map<String, Object> createTrip(@RequestBody CreateTripRequest createTripRequest) {

        log.debug("Creating a trip");

        Map<String, Object> response = new HashMap<>();
        response.put("result", aggregatorRequest.createTrip(createTripRequest));
        response.put("error", null);

        return response;
    }

    // Получение информации по заказу
    @GetMapping("/trips")
    Map<String, Object> getTrip(@RequestParam(name = "user_id") Long userId,
                                @RequestParam(name = "trip_id") Long tripId) {

        log.debug("Getting info about the trip");

        Map<String, Object> response = new HashMap<>();
        response.put("result", "not implemented");
        response.put("error", null);

        return response;
    }

    // Обновление информации по заказу
    @PutMapping("/trips")
    Map<String, Object> updateTrip(@RequestBody UpdateTripRequest updateTripRequest) {

        log.debug("Updating info about the trip");

        Map<String, Object> response = new HashMap<>();
        response.put("result", "not implemented");
        response.put("error", null);

        return response;
    }

    // Удаление заказа
    @DeleteMapping("/trips")
    Map<String, Object> deleteTrip(@RequestBody DeleteTripRequest deleteTripRequest) {

        log.debug("Deleting the trip");

        Map<String, Object> response = new HashMap<>();
        response.put("result", null);
        response.put("error", null);

        return response;
    }

}
