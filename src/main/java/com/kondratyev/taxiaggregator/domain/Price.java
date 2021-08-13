package com.kondratyev.taxiaggregator.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public PriceLevel getPriceLevel() {
        return priceLevel;
    }

    public void setPriceLevel(PriceLevel priceLevel) {
        this.priceLevel = priceLevel;
    }
}
