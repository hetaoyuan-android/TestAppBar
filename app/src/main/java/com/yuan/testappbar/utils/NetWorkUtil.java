package com.yuan.testappbar.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Set;

public class NetWorkUtil {
    public static String doGet(String urlPath) {
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                return  bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String doPost(String urlPath, HashMap<String, String> params) {
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            String paramStr = "";
            Set<HashMap.Entry<String, String>> entrySet = params.entrySet();
            for (HashMap.Entry<String, String> entry : entrySet) {
                paramStr += ("&" + entry.getKey() + "=" + entry.getValue());
            }
            paramStr = paramStr.substring(1);

            connection.setDoOutput(true);
            connection.getOutputStream().write(paramStr.getBytes());
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                return  bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
