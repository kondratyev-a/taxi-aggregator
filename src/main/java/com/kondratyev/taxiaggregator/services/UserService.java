package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.User;

public interface UserService {

    User saveUser(User user);

    User findByLogin(String login);

    User findById(Long id);

    User findByLoginAndPassword(String login, String password);
}
