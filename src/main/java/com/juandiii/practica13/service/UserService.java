package com.juandiii.practica13.service;

import com.juandiii.practica13.data.User;
import com.juandiii.practica13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public Optional<User> getUser(String id) {
        return userRepository.findById(id);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saved(User user) {
        System.out.println("Enviando correo de bienvenida a " + user.getUsername());
        String plainPassword = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        emailService.sendSimpleMessage(user.getUsername(), "PWEB FORMS, gracias por inscribirse!","Hola! "+ user.getUsername() + " \nLa contraseña es: " + plainPassword + " \n Para acceder a la página es: http://server-dev/");
        return userRepository.save(user);
    }
}
