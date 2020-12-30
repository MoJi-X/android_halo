package com.example.myapplication.model;

public class StatusParam {
    private int status;
    private String message;
    private  String devMessage;
    private Data data;
    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDevMessage() {
        return devMessage;
    }

   static class Data{

   }
}
