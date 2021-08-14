package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.domain.PriceLevel;
import com.kondratyev.taxiaggregator.repositories.PriceRepository;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PriceResponseToPrice  implements Converter<PriceResponse, Price> {

    private final LocationResponseToLocation locationConverter;
    private final PriceRepository priceRepository;

    public PriceResponseToPrice(LocationResponseToLocation locationConverter, PriceRepository priceRepository) {
        this.locationConverter = locationConverter;
        this.priceRepository = priceRepository;
    }

    @Override
    public Price convert(PriceResponse priceResponse) {
        Price price = new Price();

        price.setPrice(priceResponse.getPrice());
        price.setPriceLevel(PriceLevel.values()[priceResponse.getPriceLevel()]);
        price.setFrom(locationConverter.convert(priceResponse.getFrom()));
        price.setTo(locationConverter.convert(priceResponse.getTo()));

        Price savedPrice = priceRepository.save(price);
        log.debug("Saved PriceId: " + savedPrice.getId());

        return savedPrice;
    }

}
