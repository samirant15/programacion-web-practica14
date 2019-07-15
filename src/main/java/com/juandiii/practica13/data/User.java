package com.juandiii.practica13.data;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    public User(){
    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Id
    private String id;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String username;
    private String password;
}
