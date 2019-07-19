package com.juandiii.practica13.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String getMessage(Model model) {

        model.addAttribute("message", "sdsadsadasdsad");

        return "show";
    }
}
