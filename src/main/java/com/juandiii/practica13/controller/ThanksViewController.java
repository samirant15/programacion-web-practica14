package com.juandiii.practica13.controller;

import com.juandiii.practica13.dao.FormDao;
import com.juandiii.practica13.data.Form;
import com.juandiii.practica13.data.User;
import com.juandiii.practica13.security.CurrentUser;
import com.juandiii.practica13.security.UserPrincipal;
import com.juandiii.practica13.service.FormService;
import com.juandiii.practica13.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class ThanksViewController {

    @RequestMapping("/thanks")
    public ModelAndView index(@CurrentUser UserPrincipal currentUser, ModelAndView model) {

        model.addObject("user", currentUser);

        model.setViewName("thanks");

        return model;
    }
}
