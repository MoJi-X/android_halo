package com.example.myapplication.model;

import java.util.List;

/*
{"status":200,
 "message":"OK",
 "devMessage":null,
 "data":{"access_token":"2d4428493de04aed90c1ed973047a23d","expired_in":86400,"refresh_token":"c93264cd31e0416c865b81e071a8eca6"}}
 */
public class CheckParam {
    private int status;
    private String message;
    private  String devMessage;
    private AuthToken data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDevMessage() {
        return devMessage;
    }

    public AuthToken getData() {
        return data;
    }
}
