package com.juandiii.practica13.controller;

import com.juandiii.practica13.data.User;
import com.juandiii.practica13.service.UserService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView mav = new ModelAndView();

        User user = new User();
        mav.addObject("user", user);

        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, BindingResult result) {
        System.out.println(user.getUsername() + " " +  user.getPassword());

//        User userExists = userService.getUserByUsername(user.getUsername());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("user", new User(UUID.randomUUID().toString(), "juandiii", "123"));

        modelAndView.setViewName("index");
        return modelAndView;
    }
}
