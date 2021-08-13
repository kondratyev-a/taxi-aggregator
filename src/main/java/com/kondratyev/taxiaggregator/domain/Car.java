package com.kondratyev.taxiaggregator.domain;

import javax.persistence.Entity;

@Entity
public class Car extends BaseEntity {

    private String model;
    private int capacity;

    public Car() {
    }

    public Car(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}