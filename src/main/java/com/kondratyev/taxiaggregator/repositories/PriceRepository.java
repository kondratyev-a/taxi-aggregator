package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
