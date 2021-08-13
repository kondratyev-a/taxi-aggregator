package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.domain.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Component
public class AggregatorRequest {

    final List<AggregatorConnector> aggregatorConnectors;

    AggregatorRequest(List<AggregatorConnector> aggregatorConnectors) {
        this.aggregatorConnectors = aggregatorConnectors;
    }

    public Price bestPrice(Long userId, String fromLocation, String toLocation) {

        log.debug("Determining the best price");

        List<Price> prices = new ArrayList<>();
        for (AggregatorConnector aggregatorConnector: aggregatorConnectors) {
            prices.add(aggregatorConnector.getPrice(userId, fromLocation, toLocation));
        }

        // Выбираем лучшее предложение (ближайший автомобиль, самая дешевая цена)
        // Тут должен быть сложный алгоритм. Для тестового задания - берем минимальную цену.

        return prices
                .stream()
                .min(Comparator.comparing(Price::getPrice))
                .orElseThrow(NoSuchElementException::new);
    }

}
