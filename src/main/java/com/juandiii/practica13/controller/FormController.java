package com.juandiii.practica13.controller;

import com.juandiii.practica13.dao.FormDao;
import com.juandiii.practica13.data.Form;
import com.juandiii.practica13.data.SurveyAnswerStatistics;
import com.juandiii.practica13.data.User;
import com.juandiii.practica13.service.FormService;
import com.juandiii.practica13.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/forms")
public class FormController {

    private final FormService formService;
    private final UserService userService;

    public FormController(FormService formService, UserService userService) {
        this.formService = formService;
        this.userService = userService;
    }

    @GetMapping("")
    public List<Form> getAll() {
        return formService.getAll();
    }

    @GetMapping("/{id}")
    public Form getForm(@PathVariable String id) {
        return formService.getById(id).orElse(null);
    }

    @GetMapping("/user/{userId}")
    public Form getFormBy(@PathVariable String userId) {
        return formService.getByUserId(userId);
    }

    @PostMapping("")
    public Form saved(@RequestBody FormDao formDao) {
        User user = userService.getUser(formDao.getUserId()).orElse(null);

        if (formService.getByUserId(user.getId()) != null) {
            return null;
        }

        return formService.saved(new Form(UUID.randomUUID().toString(), formDao.getQuestion1(), formDao.getQuestion2(), formDao.getQuestion3(), formDao.getQuestion4(), user));
    }

    @GetMapping("/statistics")
    public SurveyAnswerStatistics getAllS() {
        return formService.findAll();
    }


}
