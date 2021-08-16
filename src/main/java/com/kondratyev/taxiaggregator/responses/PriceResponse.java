package com.kondratyev.taxiaggregator.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriceResponse {

    @JsonIgnore
    private Long aggregatorId;

    private Long userId;
    private Long priceId;
    private int price;
    private int priceLevel;
    private LocationResponse from;
    private LocationResponse to;

}
