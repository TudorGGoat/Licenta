package com.example.licenta.services;


import com.example.licenta.entities.UserEntity;
import com.example.licenta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String email, String password) {
        Optional<UserEntity> userOptional = userRepository.findByEmailAndPassword(email, password);
        return userOptional.isPresent();
    }
}
