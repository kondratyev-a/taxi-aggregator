package com.kondratyev.taxiaggregator.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Driver extends Individual {
    private double rating;
}
