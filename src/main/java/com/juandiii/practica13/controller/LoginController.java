package com.juandiii.practica13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String index(Model model) {

        model.addAttribute("message", "sdsadsadasdsad");

        return "index";
    }
}
