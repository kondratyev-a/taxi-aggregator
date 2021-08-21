package com.kondratyev.taxiaggregator.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kondratyev.taxiaggregator.responses.LocationResponse;
import lombok.Data;

@Data
public class CreateTripRequest {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("price_id")
    private Long priceId;

    // There is no reason to send this data when creating a trip.
    // We are confirming the price. And we have this data there.
    @JsonProperty("start_location")
    private LocationResponse from;

    @JsonProperty("finish_location")
    private LocationResponse to;

}
