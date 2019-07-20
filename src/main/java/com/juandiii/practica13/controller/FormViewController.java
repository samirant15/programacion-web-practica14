package com.juandiii.practica13.controller;

import com.juandiii.practica13.dao.FormDao;
import com.juandiii.practica13.data.Form;
import com.juandiii.practica13.data.SurveyAnswerStatistics;
import com.juandiii.practica13.data.User;
import com.juandiii.practica13.security.CurrentUser;
import com.juandiii.practica13.security.UserPrincipal;
import com.juandiii.practica13.service.FormService;
import com.juandiii.practica13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
public class FormViewController {

    @Autowired
    FormService formService;
    @Autowired
    UserService userService;

    @RequestMapping("/form")
    public ModelAndView index(@CurrentUser UserPrincipal currentUser, ModelAndView model) {

        FormDao form = new FormDao();
        model.addObject("form", form);

        model.addObject("user", currentUser);

        model.setViewName("form");

        return model;
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@Valid FormDao formDao, @CurrentUser UserPrincipal currentUser, BindingResult result) {

        User user = userService.getUser(currentUser.getId()).orElse(null);

        if (formService.getByUserId(user.getId()) != null) {
            return "redirect:/thanks";
        }

        formService.saved(new Form(UUID.randomUUID().toString(), formDao.getQuestion1(), formDao.getQuestion2(), formDao.getQuestion3(), formDao.getQuestion4(), user));

        return "redirect:/chart";
    }
}
