package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.responses.PriceResponse;

public interface PriceService {

    Price findByPriceId(Long id);

    PriceResponse savePriceResponse (PriceResponse priceResponse);

}
