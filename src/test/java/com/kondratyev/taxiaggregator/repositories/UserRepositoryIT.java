package com.kondratyev.taxiaggregator.repositories;

import com.kondratyev.taxiaggregator.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryIT {

    @Autowired
    UserRepository userRepository;

    final String login = "ivan";

    @BeforeEach
    void setUp() {
        User user = new User();
        user.setLogin(login);
        userRepository.save(user);
    }

    @Test
    void findByLogin() {
        User user = userRepository.findByLogin(login);
        assertNotNull(user);
        assertEquals(login, user.getLogin());
    }
}