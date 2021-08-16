package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.domain.PriceLevel;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PriceToPriceResponseTest {

    public static final int PRICE = 415;
    public static final Long AGGREGATOR_ID = 12L;
    public static final Long PRICE_ID = 3921215L;
    public static final String LOCATION = "55.035705,82.896254";
    public static final PriceLevel PRICE_LEVEL = PriceLevel.PREMIUM;

    PriceToPriceResponse converter;

    @Mock
    LocationToLocationResponse locationConverter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        converter = new PriceToPriceResponse(new LocationToLocationResponse());
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void convert() {

        when(locationConverter.convert(any())).thenReturn(new LocationResponse(LOCATION));

        Price price = new Price();
        price.setPrice(PRICE);
        price.setAggregatorId(AGGREGATOR_ID);
        price.setPriceId(PRICE_ID);
        price.setFrom(new Location(LOCATION));
        price.setTo(new Location(LOCATION));
        price.setPriceLevel(PRICE_LEVEL);

        PriceResponse priceResponse = converter.convert(price);

        assertNotNull(price);
        assertEquals(PRICE, priceResponse.getPrice());
        assertEquals(AGGREGATOR_ID, priceResponse.getAggregatorId());
        assertEquals(PRICE_ID, priceResponse.getPriceId());
        assertEquals(LOCATION, priceResponse.getFrom().toString());
        assertEquals(LOCATION, priceResponse.getTo().toString());
        assertEquals(PRICE_LEVEL, PriceLevel.values()[priceResponse.getPriceLevel()]);

    }
}