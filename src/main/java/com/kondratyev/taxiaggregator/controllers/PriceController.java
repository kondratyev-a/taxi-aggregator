package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.connectors.AggregatorRequest;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PriceController {

    private final AggregatorRequest aggregatorRequest;

    public PriceController(AggregatorRequest aggregatorRequest) {
        this.aggregatorRequest = aggregatorRequest;
    }

    @GetMapping("/prices")
    ResponseEntity<PriceResponse> prices(@RequestParam(name = "user_id") Long userId,
                       @RequestParam(name = "start_place_point") String fromLocation,
                       @RequestParam(name = "finish_place_point") String toLocation) {

        log.debug("Getting prices");
        return ResponseEntity.ok(aggregatorRequest.getPrice(userId, fromLocation, toLocation));
    }
}
