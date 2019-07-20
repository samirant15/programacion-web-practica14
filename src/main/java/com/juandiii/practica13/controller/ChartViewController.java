package com.juandiii.practica13.controller;

import com.juandiii.practica13.data.Form;
import com.juandiii.practica13.security.CurrentUser;
import com.juandiii.practica13.security.UserPrincipal;
import com.juandiii.practica13.service.FormService;
import com.juandiii.practica13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChartViewController {

    @Autowired
    FormService formService;
    @Autowired
    UserService userService;

    @RequestMapping("/chart")
    public String index(@CurrentUser UserPrincipal currentUser, Model model) {

        Form form = formService.getByUserId(currentUser.getId());

        model.addAttribute("form", form);
        model.addAttribute("user", currentUser);

        return "chart";
    }
}
