package com.kondratyev.taxiaggregator.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Getter
@Setter
@Entity
public class Price extends BaseEntity {

    private int price;

    @Enumerated(value = EnumType.STRING)
    private PriceLevel priceLevel;

    @OneToOne
    private Location from;

    @OneToOne
    private Location to;

    public Price() {
    }

    public Price(int price, Location from, Location to, PriceLevel priceLevel) {
        this.price = price;
        this.from = from;
        this.to = to;
        this.priceLevel = priceLevel;
    }

}
