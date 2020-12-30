package com.example.myapplication.utils.httputil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Put {
    private String testurl="http://47.113.204.48/api/admin/posts/comments/4/status/PUBLISHED";
    public static int put(String strURL, String params,String Authoriztion) {
        System.out.println(strURL);
        System.out.println(params);
        String urlNameString = strURL + params;
        BufferedReader reader = null;
        try {
            URL url = new URL(urlNameString);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("PUT"); // 设置请求方式
            // connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.addRequestProperty("Content-Type","text/plain");
            connection.addRequestProperty("Content-Type","/");
            connection.addRequestProperty("Admin-Authorization",Authoriztion);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setReadTimeout(10000);//设置读取超时时间
            connection.setConnectTimeout(10000);//设置连接超时时间
            connection.connect();

            // 读取响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
                res += line;
            }
            reader.close();
            return connection.getResponseCode();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return 0; // 自定义错误信息
    }
}
