package com.kondratyev.taxiaggregator.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DeleteTripResponse {

    @JsonProperty("trip_id")
    private Long tripId;

}
