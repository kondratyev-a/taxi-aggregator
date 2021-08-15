package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.PriceResponseToPrice;
import com.kondratyev.taxiaggregator.convertors.PriceToPriceResponse;
import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.repositories.PriceRepository;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceResponseToPrice priceResponseToPrice;
    private final PriceToPriceResponse priceToPriceResponse;
    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceResponseToPrice priceResponseToPrice, PriceToPriceResponse priceToPriceResponse,
                            PriceRepository priceRepository) {
        this.priceResponseToPrice = priceResponseToPrice;
        this.priceToPriceResponse = priceToPriceResponse;
        this.priceRepository = priceRepository;
    }

    @Override
    public Price findByPriceId(Long id) {
        Optional<Price> priceOptional = priceRepository.findByPriceId(id);
        if (priceOptional.isEmpty()) {
            throw new RuntimeException("Price not found");
        }
        return priceOptional.get();
    }

    @Override
    public PriceResponse savePriceResponse(PriceResponse priceResponse) {
        Price convertedPrice = priceResponseToPrice.convert(priceResponse);

        Price savedPrice = priceRepository.save(convertedPrice);
        log.debug("Saved PriceId: " + savedPrice.getId());
        return priceToPriceResponse.convert(savedPrice);
    }
}
