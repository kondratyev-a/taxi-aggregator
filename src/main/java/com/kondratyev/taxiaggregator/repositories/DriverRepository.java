package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}
