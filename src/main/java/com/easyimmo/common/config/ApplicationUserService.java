package com.easyimmo.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.easyimmo.user.model.User;
import com.easyimmo.user.repository.UserRepository;

@Service
public class ApplicationUserService implements UserDetailsService {

    @Autowired
    UserRepository userDAO;

    @Override
    public UserDetailsImpl loadUserByUsername(String email) {
        User user = userDAO.findByUsername(email).orElseThrow(RuntimeException::new);
        return UserDetailsImpl.build(user);
    }
}
