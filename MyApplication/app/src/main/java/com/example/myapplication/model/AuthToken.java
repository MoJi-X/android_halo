package com.example.myapplication.model;

public class AuthToken {

    /**
     * Access token.
     */
    private String access_token;

    /**
     * Expired in. (seconds)
     */
    private int expired_in;

    /**
     * Refresh token.
     */
    private String refresh_token;

    public String getAccess_token() {
        return access_token;
    }

    public int getExpired_in() {
        return expired_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
