package com.juandiii.practica13.data;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Form {

    public Form() {
    }

    public Form(String id, Integer question1, Integer question2, Integer question3, String question4, User user) {
        this.id = id;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.user = user;
    }

    @Id
    private String id;
    private Integer question1;
    private Integer question2;
    private Integer question3;
    private String question4;
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
