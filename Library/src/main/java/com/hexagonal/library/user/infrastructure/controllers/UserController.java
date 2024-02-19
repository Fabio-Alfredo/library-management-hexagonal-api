package com.hexagonal.library.user.infrastructure.controllers;

import com.hexagonal.library.user.aplication.service.UserService;
import com.hexagonal.library.user.domain.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String saveUser(User user){
       return userService.createdUser(user);
    }

}
