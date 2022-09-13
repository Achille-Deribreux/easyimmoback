package com.easyimmo.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easyimmo.user.dto.UserBody;
import com.easyimmo.user.model.User;
import com.easyimmo.user.service.UserService;
import com.easyimmo.user.utils.UserConverter;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody UserBody user){
        User addedUser = userService.addUser(UserConverter.convertToUser(user));
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }
}
