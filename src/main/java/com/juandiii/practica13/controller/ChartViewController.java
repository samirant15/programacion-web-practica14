package com.juandiii.practica13.controller;

import com.juandiii.practica13.security.CurrentUser;
import com.juandiii.practica13.security.UserPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartViewController {
    @RequestMapping("/chart")
    public String index(@CurrentUser UserPrincipal currentUser, Model model) {

        model.addAttribute("user", currentUser);

        return "chart";
    }
}
