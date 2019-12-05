package com.computer.shop.controllers;

import com.computer.shop.models.Info;
import com.computer.shop.models.User;
import com.computer.shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.sql.SQLIntegrityConstraintViolationException;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    private final ExampleMatcher credentialMatcher;

    public UserController() {
        credentialMatcher = createMatcher();
    }

    @PostMapping("/login")
    public boolean IsUserValid(@Valid @RequestBody User user) {
        Example<User> example = Example.of(user, credentialMatcher);
        return userRepository.exists(example);
    }
    @PostMapping("/register")
    public boolean createNewUser(@Valid @RequestBody User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }


    private ExampleMatcher createMatcher() {
        return ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("login", ignoreCase())
                .withMatcher("password", ignoreCase());
    }
}
