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

    public static PriceLevel fromValue(int code) {
        for (PriceLevel priceLevel : PriceLevel.values()) {
            if (priceLevel.value == code) {
                return priceLevel;
            }
        }
        throw new IllegalArgumentException("No Price level with code " + code + " found");
    }
}