package com.juandiii.practica13.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartViewController {
    @RequestMapping("/chart")
    public String index(Model model) {

        model.addAttribute("message", "sdsadsadasdsad");

        return "chart";
    }
}
