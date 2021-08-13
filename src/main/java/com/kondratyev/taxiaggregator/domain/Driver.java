package com.kondratyev.taxiaggregator.domain;

import javax.persistence.Entity;

@Entity
public class Driver extends Individual {
    private double score;

    public Driver() {
    }

    public Driver(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
