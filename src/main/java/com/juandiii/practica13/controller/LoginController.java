package com.juandiii.practica13.controller;

import com.juandiii.practica13.dao.FormDao;
import com.juandiii.practica13.data.User;
import com.juandiii.practica13.security.CurrentUser;
import com.juandiii.practica13.security.UserPrincipal;
import com.juandiii.practica13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(@CurrentUser UserPrincipal currentUser) {
        ModelAndView modelAndView = new ModelAndView();

        if (currentUser == null) {
            User user = new User();
            modelAndView.addObject("user", user);
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("form");
            modelAndView.addObject("user", currentUser);
            FormDao form = new FormDao();
            modelAndView.addObject("form", form);
        }
        return modelAndView;
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView mav = new ModelAndView();

        User user = new User();
        mav.addObject("user", user);

        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String login(@Valid User user, BindingResult result) {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(user.getUsername() + " " + user.getPassword());

        User userExists = userService.getUserByUsername(user.getUsername());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", userExists);

        modelAndView.setViewName("form");

        return "redirect:/form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@Valid User user, BindingResult result) {
        System.out.println("Register: " + user.getUsername());
        user.setId(UUID.randomUUID().toString());
        user.setPassword(generatePassword());

        userService.saved(user);

        return "redirect:/form";
    }

    private static String generatePassword() {
        StringBuilder returnValue = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
