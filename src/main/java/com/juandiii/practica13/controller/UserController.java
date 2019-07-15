package com.juandiii.practica13.controller;

import com.juandiii.practica13.dao.UserDao;
import com.juandiii.practica13.data.User;
import com.juandiii.practica13.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id).orElse(null);
    }

    @PostMapping(value = "")
    public User savedUser(@RequestBody UserDao userDao) {
        return userService.saved(new User(UUID.randomUUID().toString(), userDao.getUsername(), generatePassword()));
    }

    private static String generatePassword() {
        StringBuilder returnValue = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
