package com.kondratyev.taxiaggregator.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DriverResponse {
    private String name;
    private double rating;
}
