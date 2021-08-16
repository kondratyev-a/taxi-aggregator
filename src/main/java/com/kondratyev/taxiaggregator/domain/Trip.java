package com.kondratyev.taxiaggregator.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

// Если использовать имя Order, то Hibernate валится при запуске
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Trip extends BaseEntity {

    // Идентификатор внешней системы
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
