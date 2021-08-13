package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Trip, Long> {
}