package com.kondratyev.taxiaggregator.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriceResponse {

    private Long priceId;
    private int price;
    private int priceLevel;
    private LocationResponse from;
    private LocationResponse to;

}
