package com.kondratyev.taxiaggregator.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

// If you use the name Order, then Hibernate crashes on startup
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Trip extends BaseEntity {

    // External system identifier
    private Long tripId;

    private long aggregatorId;

    private Long userId;

    @OneToOne
    private Price price;

    @OneToOne
    private Car car;

    @OneToOne
    private Driver driver;

}
