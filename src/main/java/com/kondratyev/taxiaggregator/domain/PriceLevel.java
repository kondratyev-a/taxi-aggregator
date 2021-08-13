package com.kondratyev.taxiaggregator.domain;

public enum PriceLevel {
    ECONOMY(1), PREMIUM(2);
    private final int value;

    PriceLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}