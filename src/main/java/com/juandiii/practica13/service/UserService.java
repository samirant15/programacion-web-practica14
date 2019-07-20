package com.juandiii.practica13.service;

import com.juandiii.practica13.data.User;
import com.juandiii.practica13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saved(User user) {
//        emailService.sendSimpleMessage(user.getUsername(), "Barcamp, gracias por inscribirse!","Hola! "+ user.getUsername() + " \nLa contraseña es: " + user.getPassword() + " \n Para acceder a la página es: http://testing.com/");
        return userRepository.save(user);
    }
}
