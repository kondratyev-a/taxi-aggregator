package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.domain.Price;

public interface AggregatorConnector {

    Price getPrice(Long userId, String fromLocation, String toLocation);

}
