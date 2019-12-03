package com.computer.shop.controllers;

import com.computer.shop.models.User;
import com.computer.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@RestController
public class LoginController {
    @Autowired
    UserRepository userRepository;
    private final ExampleMatcher credentialMatcher;

    public LoginController() {
        credentialMatcher = createMatcher();
    }

    @PostMapping("/login")
    public boolean IsUserValid(@RequestBody User user) {
        Example<User> example = Example.of(user, credentialMatcher);
        return userRepository.exists(example);
    }

    private ExampleMatcher createMatcher() {
        return ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("login", ignoreCase())
                .withMatcher("password", ignoreCase());
    }
}
