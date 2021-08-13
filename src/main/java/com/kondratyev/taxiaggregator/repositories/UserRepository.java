package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
