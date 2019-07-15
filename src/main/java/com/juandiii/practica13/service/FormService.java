package com.juandiii.practica13.service;

import com.juandiii.practica13.data.Form;
import com.juandiii.practica13.data.SurveyAnswerStatistics;
import com.juandiii.practica13.repository.FormRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    private final FormRepository formRepository;

    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public Optional<Form> getById(String id) {
        return formRepository.findById(id);
    }

    public List<Form> getAll() {
        return formRepository.findAll();
    }

    public Form getByUserId(String userId) {
        return formRepository.findByUserId(userId);
    }

    public Form saved(Form form) {
        return formRepository.save(form);
    }

    public SurveyAnswerStatistics findAll() {
        return formRepository.findSurveyCount();
    }
}
