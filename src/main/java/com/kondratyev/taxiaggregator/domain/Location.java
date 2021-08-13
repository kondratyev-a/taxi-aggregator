package com.kondratyev.taxiaggregator.domain;

import javax.persistence.Entity;

@Entity
public class Location extends BaseEntity {

    private double latitude;
    private double longitude;

    public Location() {

    }

    public Location(String location) {
        String[] coordinates = location.split(",");
        this.latitude = Double.parseDouble(coordinates[0]);
        this.longitude = Double.parseDouble(coordinates[1]);
    }

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
