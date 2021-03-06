package com.kondratyev.taxiaggregator.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteTripRequest {

    @JsonProperty("trip_id")
    private Long tripId;

}
