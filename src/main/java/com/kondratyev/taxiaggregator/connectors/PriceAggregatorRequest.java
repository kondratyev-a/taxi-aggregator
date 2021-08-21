package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.responses.PriceResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class PriceAggregatorRequest {

    public static PriceResponse getPriceResponse(List<AggregatorConnector> aggregatorConnectors,
                                                 Long userId, String fromLocation, String toLocation) {

        log.debug("Determining the best price");
        // Asynchronous getting prices.
        int numOfConnectors = aggregatorConnectors.size();
        CompletableFuture<?>[] array = new CompletableFuture<?>[numOfConnectors];
        for (int i = 0; i < numOfConnectors; i++) {
            AggregatorConnector aggregatorConnector = aggregatorConnectors.get(i);
            CompletableFuture<PriceResponse> response = aggregatorConnector.getPrice(userId, fromLocation, toLocation);
            array[i] = response;
        }

        // We are waiting for the completion of all threads.
        CompletableFuture.allOf(CompletableFuture.allOf(array)).join();

        // Getting responses from CompletableFuture
        List<PriceResponse> prices = new ArrayList<>();
        for (int i = 0; i < numOfConnectors; i++) {
            try {
                prices.add((PriceResponse) array[i].get());
            } catch (InterruptedException | ExecutionException e) {
                // If we don't receive answer from one aggregator - it is normal situation.
                log.warn("Error on getting answer from aggregator: " + e.getMessage());
            }
        }

        // We need to choose the best price (the nearest car, the cheapest price).
        // There must be some kind of algorithm. For a test task, we take the minimum price.
        return chooseBestPrice(prices);
    }

    private static PriceResponse chooseBestPrice(List<PriceResponse> prices) {

        return prices
                .stream()
                .min(Comparator.comparing(PriceResponse::getPrice))
                .orElseThrow(NoSuchElementException::new);
    }

}
