package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
