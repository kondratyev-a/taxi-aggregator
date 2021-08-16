package com.kondratyev.taxiaggregator.convertors;

import com.kondratyev.taxiaggregator.domain.Location;
import com.kondratyev.taxiaggregator.domain.Price;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import com.kondratyev.taxiaggregator.responses.PriceResponse;
import com.kondratyev.taxiaggregator.services.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PriceResponseToPriceTest {

    public static final int PRICE = 415;
    public static final Long AGGREGATOR_ID = 12L;
    public static final Long PRICE_ID = 3921215L;
    public static final String LOCATION = "55.035705,82.896254";
    public static final int PRICE_LEVEL = 1;

    @Mock
    LocationService locationService;

    PriceResponseToPrice converter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        converter = new PriceResponseToPrice(locationService);
    }

    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    @Test
    void convert() {

        when(locationService.saveLocationResponse(any())).thenReturn(new Location(LOCATION));

        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setPrice(PRICE);
        priceResponse.setAggregatorId(AGGREGATOR_ID);
        priceResponse.setPriceId(PRICE_ID);
        priceResponse.setFrom(new LocationResponse(LOCATION));
        priceResponse.setTo(new LocationResponse(LOCATION));
        priceResponse.setPriceLevel(PRICE_LEVEL);

        Price price = converter.convert(priceResponse);

        assertNotNull(price);
        assertEquals(PRICE, price.getPrice());
        assertEquals(AGGREGATOR_ID, price.getAggregatorId());
        assertEquals(PRICE_ID, price.getPriceId());
        assertEquals(LOCATION, price.getFrom().toString());
        assertEquals(LOCATION, price.getTo().toString());
        assertEquals(PRICE_LEVEL, price.getPriceLevel().ordinal());

    }
}