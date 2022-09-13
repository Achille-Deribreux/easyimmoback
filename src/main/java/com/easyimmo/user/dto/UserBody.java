package com.easyimmo.user.dto;

public class UserBody {

    private String username;
    private String password;

    public UserBody() {
        //Empty constructor
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
