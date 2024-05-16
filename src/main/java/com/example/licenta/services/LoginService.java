package com.example.licenta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.licenta.repositories.UserRepository;
import com.example.licenta.entities.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public String login(String email, String password) {
        Optional<UserEntity> userOptional = userRepository.findByEmailAndPassword(email, password);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            String role = user.getRol();
            if ("user".equals(role)) {
                return "/api/users/user";
            } else if ("admin".equals(role)) {
                return "/api/users/admin";
            }
        }
        return "/login"; // Redirect to login endpoint if user not found or invalid credentials
    }
}
