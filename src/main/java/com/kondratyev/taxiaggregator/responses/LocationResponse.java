package com.kondratyev.taxiaggregator.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocationResponse {

    private Long LocationId;
    private double latitude;
    private double longitude;

    public LocationResponse(String location) {
        String[] coordinates = location.split(",");
        this.latitude = Double.parseDouble(coordinates[0]);
        this.longitude = Double.parseDouble(coordinates[1]);
    }

    @Override
    public String toString() {
        return latitude + "," + longitude;
    }

}
