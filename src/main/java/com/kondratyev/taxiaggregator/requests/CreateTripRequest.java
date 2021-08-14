package com.kondratyev.taxiaggregator.requests;

import com.kondratyev.taxiaggregator.domain.Location;
import lombok.Data;

@Data
public class CreateTripRequest {

    private Long userId;
    private Long priceId;

    private Location start_location;
    private Location finish_location;

}
