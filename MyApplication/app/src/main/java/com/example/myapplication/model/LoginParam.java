package com.example.myapplication.model;

public class LoginParam {
    private String username;
    private String password;
    private String authcode;

    public LoginParam(String username, String password, String authcode) {
        this.username = username;
        this.password = password;
        this.authcode = authcode;
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

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }
}
