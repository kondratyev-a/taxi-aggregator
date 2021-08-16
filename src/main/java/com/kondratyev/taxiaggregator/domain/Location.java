package com.kondratyev.taxiaggregator.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Location extends BaseEntity {

    private double latitude;
    private double longitude;

    public Location (String location) {
        String[] coordinates = location.split(",");
        this.latitude = Double.parseDouble(coordinates[0]);
        this.longitude = Double.parseDouble(coordinates[1]);
    }

    @Override
    public String toString() {
        return latitude + "," + longitude;
    }
}
