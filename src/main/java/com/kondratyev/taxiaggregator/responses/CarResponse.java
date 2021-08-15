package com.kondratyev.taxiaggregator.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarResponse {

    private String model;
    private int capacity;

}
