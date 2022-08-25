package com.easyimmo.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.easyimmo.common.exception.UserAlreadyExistsException;
import com.easyimmo.user.model.User;
import com.easyimmo.user.repository.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User addUser (User user){
        if(userRepository.findByUsername(user.getUsername()).isPresent())
            throw new UserAlreadyExistsException(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
