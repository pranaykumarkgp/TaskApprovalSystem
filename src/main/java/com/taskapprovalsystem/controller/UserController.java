package com.taskapprovalsystem.controller;

import com.taskapprovalsystem.entity.User;
import com.taskapprovalsystem.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try{
            userService.registerUser(user);
            logger.info("User registered successfully");
        } catch (Exception e) {
            logger.error("Error encountered while creating a new user, {}, {}", e.getMessage(),  e.getStackTrace());
        }
        return ResponseEntity.ok("User registered successfully");
    }
}
