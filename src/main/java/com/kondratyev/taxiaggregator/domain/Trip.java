package com.kondratyev.taxiaggregator.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

// Если использовать имя Order, то Hibernate валится при запуске
@Entity
public class Trip extends BaseEntity {

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
}
