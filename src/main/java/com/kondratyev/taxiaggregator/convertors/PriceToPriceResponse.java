package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PriceToPriceResponse implements Converter<Price, PriceResponse> {

    private final LocationToLocationResponse locationConverter;

    public PriceToPriceResponse(LocationToLocationResponse locationConverter) {
        this.locationConverter = locationConverter;
    }

    @Override
    public PriceResponse convert(Price price) {

        PriceResponse priceResponse = new PriceResponse();

        priceResponse.setUserId(price.getUserId());
        priceResponse.setAggregatorId(price.getAggregatorId());
        priceResponse.setPriceId(price.getPriceId());
        priceResponse.setPrice(price.getPrice());
        priceResponse.setPriceLevel(price.getPriceLevel().getValue());
        priceResponse.setFrom(locationConverter.convert(price.getFrom()));
        priceResponse.setTo(locationConverter.convert(price.getTo()));

        return priceResponse;
    }
}
