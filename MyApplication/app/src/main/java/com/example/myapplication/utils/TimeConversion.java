package com.example.myapplication.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {
    public static String TimeConversion(long s) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(s))));      // 时间戳转换成时间
        return sd;
    }
}
