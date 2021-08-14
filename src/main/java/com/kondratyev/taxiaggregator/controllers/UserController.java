package com.kondratyev.taxiaggregator.controllers;

import com.kondratyev.taxiaggregator.configs.jwt.JwtProvider;
import com.kondratyev.taxiaggregator.domain.User;
import com.kondratyev.taxiaggregator.requests.AuthRequest;
import com.kondratyev.taxiaggregator.requests.RegistrationRequest;
import com.kondratyev.taxiaggregator.responses.AuthResponse;
import com.kondratyev.taxiaggregator.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    public UserController(UserService userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationRequest registrationRequest) {

        User existingUser = userService.findByLogin(registrationRequest.getLogin());

        if (existingUser != null) {
            return "User already exists with id: " + existingUser.getId();
        } else {
            User user = new User();
            user.setName(registrationRequest.getName());
            user.setPassword(registrationRequest.getPassword());
            user.setLogin(registrationRequest.getLogin());
            User newUser = userService.saveUser(user);
            return "User created with id: " + newUser.getId();
        }
    }

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }
}
