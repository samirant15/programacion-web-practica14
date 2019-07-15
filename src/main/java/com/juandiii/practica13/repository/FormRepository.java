package com.juandiii.practica13.repository;

import com.juandiii.practica13.data.Form;
import com.juandiii.practica13.data.SurveyAnswerStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FormRepository extends JpaRepository<Form, String> {

    Form findByUserId(String userId);

    @Query(nativeQuery = true, value = "SELECT " +
            "v.question1 as answer1, COUNT(v.question1) as cnt1, v.question2 as answer2, COUNT(v.question2) as cnt2, v.question3 as answer3, COUNT(v.question3) as cnt3, v.question4 as answer4, COUNT(v.question4) as cnt4  " +
            "FROM Form as v " +
            "GROUP BY v.question1, v.question2, v.question3, v.question4")
    @Transactional
    SurveyAnswerStatistics findSurveyCount();
}
