package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TripRepository extends JpaRepository<Trip, Long> {
    Optional<Trip> findByTripId(Long priceId);
}