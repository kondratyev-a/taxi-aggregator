package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.convertors.PriceResponseToPrice;
import com.kondratyev.taxiaggregator.convertors.PriceToPriceResponse;
import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

    private final PriceResponseToPrice priceResponseToPrice;
    private final PriceToPriceResponse priceToPriceResponse;

    public PriceServiceImpl(PriceResponseToPrice priceResponseToPrice, PriceToPriceResponse priceToPriceResponse) {
        this.priceResponseToPrice = priceResponseToPrice;
        this.priceToPriceResponse = priceToPriceResponse;
    }

    @Override
    public PriceResponse savePriceResponse(PriceResponse priceResponse) {
        Price savedPrice = priceResponseToPrice.convert(priceResponse);
        return priceToPriceResponse.convert(savedPrice);
    }
}
