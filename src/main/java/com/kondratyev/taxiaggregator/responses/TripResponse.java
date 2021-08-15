package com.kondratyev.taxiaggregator.responses;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TripResponse {

    @JsonIgnore
    private Long aggregatorId;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("trip_id")
    private Long tripId;
    private int price;

    @JsonProperty("price_id")
    private Long priceId;

    private DriverResponse driver;
    private CarResponse car;

    private LocationResponse from;
    private LocationResponse to;

}
