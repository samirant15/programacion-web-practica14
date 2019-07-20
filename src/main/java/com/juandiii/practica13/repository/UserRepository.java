package com.juandiii.practica13.repository;

import com.juandiii.practica13.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    public User findByUsername(String username);
}
