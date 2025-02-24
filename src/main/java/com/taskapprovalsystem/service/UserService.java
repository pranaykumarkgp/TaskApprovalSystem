package com.taskapprovalsystem.service;


import com.taskapprovalsystem.entity.User;
import com.taskapprovalsystem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public boolean registerUser(User user) {
        User newUser = new User();

        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setUsername(user.getUsername());
        newUser.setRole(user.getRole());
        try{
            userRepository.save(newUser);
            logger.info("User was persisted in the database successfully");
            return true;
        } catch (Exception e) {
            logger.error("Error encountered while creating a new user, {}",  e.getMessage());
            return false;
        }

    }
}