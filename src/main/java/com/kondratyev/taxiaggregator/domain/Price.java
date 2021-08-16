package com.kondratyev.taxiaggregator.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Price extends BaseEntity {

    // Идентификатор внешней системы
    private Long priceId;

    private Long userId;

    private long aggregatorId;

    private int price;

    @Enumerated(value = EnumType.STRING)
    private PriceLevel priceLevel;

    @OneToOne
    private Location from;

    @OneToOne
    private Location to;

}
