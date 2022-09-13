package com.easyimmo.common.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUser {

    private CurrentUser() {
    }

    public static String getCurrentUserName(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
