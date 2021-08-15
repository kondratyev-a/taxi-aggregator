package com.kondratyev.taxiaggregator.exceptions;

public class TripNotFoundException extends RuntimeException {
    public TripNotFoundException(Long id) {
        super("Could not find trip with id " + id);
    }
}