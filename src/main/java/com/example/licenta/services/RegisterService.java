package com.example.licenta.services;


import com.example.licenta.entities.UserEntity;
import com.example.licenta.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UserRepository userRepository;

    @Autowired
    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String firstName, String lastName, String email, String password, String rol) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Mail already exists");
        }

        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRol("user");
        userRepository.save(user);
    }
}
