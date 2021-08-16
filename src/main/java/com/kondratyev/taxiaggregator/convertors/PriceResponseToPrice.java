package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.domain.PriceLevel;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.services.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PriceResponseToPrice  implements Converter<PriceResponse, Price> {

    private final LocationService locationService;

    public PriceResponseToPrice(LocationService locationService) {
        this.locationService = locationService;
    }

    @Override
    public Price convert(PriceResponse priceResponse) {
        Price price = new Price();

        price.setUserId(priceResponse.getUserId());
        price.setAggregatorId(priceResponse.getAggregatorId());
        price.setPriceId(priceResponse.getPriceId());
        price.setPrice(priceResponse.getPrice());
        price.setPriceLevel(PriceLevel.fromValue(priceResponse.getPriceLevel()));
        price.setFrom(locationService.saveLocationResponse(priceResponse.getFrom()));
        price.setTo(locationService.saveLocationResponse(priceResponse.getTo()));

        return price;
    }

}
