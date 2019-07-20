package com.juandiii.practica13.controller;

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

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

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
    public ModelAndView login(@Valid User user, BindingResult result) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        System.out.println(user.getUsername() + " " + user.getPassword());

        User userExists = userService.getUserByUsername(user.getUsername());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", userExists);

        modelAndView.setViewName("form");
        return modelAndView;
    }
}
