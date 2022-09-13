package com.easyimmo.user.utils;

import com.easyimmo.user.dto.UserBody;
import com.easyimmo.user.model.User;

public class UserConverter {

    private UserConverter() {
    }

    public static User convertToUser (UserBody userBody){
        return new User()
                .username(userBody.getUsername())
                .password(userBody.getPassword());
    }
}
