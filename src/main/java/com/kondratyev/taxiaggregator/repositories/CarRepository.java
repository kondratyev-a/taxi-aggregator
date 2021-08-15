package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
