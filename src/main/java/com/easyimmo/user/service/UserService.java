package com.easyimmo.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.easyimmo.common.exception.NotBelongToUserException;
import com.easyimmo.common.exception.UserAlreadyExistsException;
import com.easyimmo.common.exception.UserNotFoundException;
import com.easyimmo.common.utils.CurrentUser;
import com.easyimmo.user.model.User;
import com.easyimmo.user.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("username :"+ username));
    }

    public User addUser (User user){
        if(userRepository.findByUsername(user.getUsername()).isPresent())
            throw new UserAlreadyExistsException(" ");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Integer getUserId(String username){
        return getByUsername(username).getId();
    }

    public void checkUser(Integer entityUserId){
        Integer userId = getUserId(CurrentUser.getCurrentUserName());
        if(!userId.equals(entityUserId))
            throw new NotBelongToUserException(String.valueOf(userId));
    }
}
