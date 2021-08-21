package com.kondratyev.taxiaggregator.bootstrap;

import com.kondratyev.taxiaggregator.domain.User;
import com.kondratyev.taxiaggregator.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;

    public DataLoader(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) {

        loadUsers();
    }

    private void loadUsers() {

        // Users
        log.debug("Starting loading users");

        User ivan = new User();
        ivan.setName("Ivan Petrov");
        ivan.setLogin("ivan");
        ivan.setPassword("password");
        userService.saveUser(ivan);

        User petr = new User();
        petr.setName("Petr Ivanov");
        petr.setLogin("petr");
        petr.setPassword("password");
        userService.saveUser(petr);

        log.debug("Users loaded");

    }
}