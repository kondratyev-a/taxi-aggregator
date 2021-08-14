package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.User;

public interface UserService {

    public User saveUser(User user);

    public User findByLogin(String login);

    public User findByLoginAndPassword(String login, String password);
}
