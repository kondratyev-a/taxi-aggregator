package com.kondratyev.taxiaggregator.connectors;

import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.domain.PriceLevel;
import com.kondratyev.taxiaggregator.repositories.LocationRepository;
import com.kondratyev.taxiaggregator.repositories.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AggregatorConnectorYandex implements AggregatorConnector {

    final PriceRepository priceRepository;
    final LocationRepository locationRepository;

    AggregatorConnectorYandex(PriceRepository priceRepository,
                   LocationRepository locationRepository) {
        this.priceRepository = priceRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public Price getPrice(Long userId, String fromLocation, String toLocation) {
        log.debug("get Yandex price. Here should be API call.");
        return dummyPrice(324, fromLocation, toLocation, PriceLevel.PREMIUM);
    }

    private Price dummyPrice(int price, String fromLocation, String toLocation, PriceLevel priceLevel) {

        Price dummyPrice = new Price();

        dummyPrice.setPrice(price);

        Location from = new Location(fromLocation);
        dummyPrice.setFrom(locationRepository.save(from));

        Location to = new Location(toLocation);
        dummyPrice.setTo(locationRepository.save(to));

        dummyPrice.setPriceLevel(priceLevel);

        return priceRepository.save(dummyPrice);
    }
}