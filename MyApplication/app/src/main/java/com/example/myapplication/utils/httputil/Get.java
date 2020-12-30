package com.example.myapplication.utils.httputil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Get {
    /**
     *
     * @param strURL
     * @param params
     * @param Authoriztion token
     * @return
     */
    public static String get(String strURL, String params,String Authoriztion) {
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

            // connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.addRequestProperty("Content-Type","text/plain");
            connection.addRequestProperty("Content-Type","/");
            connection.addRequestProperty("Admin-Authorization",Authoriztion);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setDoOutput(false);
            connection.connect();
            // 读取响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
                res += line;
            }
            reader.close();
            return res;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "error"; // 自定义错误信息
    }
}
