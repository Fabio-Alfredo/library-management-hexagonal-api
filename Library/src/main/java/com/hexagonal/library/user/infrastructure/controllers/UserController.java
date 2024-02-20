package com.hexagonal.library.user.infrastructure.controllers;

import com.hexagonal.library.user.aplication.service.UserService;
import com.hexagonal.library.user.domain.models.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/created")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody User user){
       return userService.createdUser(user);
    }

}
