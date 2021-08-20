package com.kondratyev.taxiaggregator.services;

import com.kondratyev.taxiaggregator.domain.User;
import com.kondratyev.taxiaggregator.exceptions.UserNotFoundException;
import com.kondratyev.taxiaggregator.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException(login);
        }

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Incorrect password for user with login " + login);
        }
        return user;

    }
}
