package com.kondratyev.taxiaggregator.exceptions;

public class PriceNotFoundException extends RuntimeException {
    public PriceNotFoundException(Long id) {
        super("Could not find price with id " + id);
    }
}
