package com.kondratyev.taxiaggregator.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

// Если использовать имя Order, то Hibernate валится при запуске
@Entity
public class Trip extends BaseEntity {

    @OneToOne
    private User user;

    @OneToOne
    private Price price;

    @OneToOne
    private Car car;

    @OneToOne
    private Driver driver;

    public Trip() {
    }

    public Trip(Car car, Driver driver) {
        this.car = car;
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
