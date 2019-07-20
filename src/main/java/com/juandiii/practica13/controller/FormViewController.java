package com.juandiii.practica13.controller;

import com.juandiii.practica13.dao.FormDao;
import com.juandiii.practica13.data.Form;
import com.juandiii.practica13.data.SurveyAnswerStatistics;
import com.juandiii.practica13.data.User;
import com.juandiii.practica13.security.CurrentUser;
import com.juandiii.practica13.security.UserPrincipal;
import com.juandiii.practica13.service.FormService;
import com.juandiii.practica13.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class FormViewController {
    @RequestMapping("/form")
    public String index(@CurrentUser UserPrincipal currentUser, Model model) {

        model.addAttribute("user", currentUser);

        return "form";
    }
}
