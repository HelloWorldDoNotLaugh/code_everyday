package com.wy;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            String url = "http://localhost:8002/api/routes/mingmo";
            String jsonInputString = "{\"target\": \"https://modelwise.tcloud.tongdun.cn/user/login\"}";

            // 创建 URL 对象
            URL urlObj = new URL(url);

            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

            // 设置请求方法为 POST
            connection.setRequestMethod("POST");

            // 启用输入输出流
            connection.setDoOutput(true);

            // 设置请求头的 Content-Type
            connection.setRequestProperty("Content-Type", "application/json");

            // 获取输出流并写入请求体
            try (OutputStream os = connection.getOutputStream();
                 OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8")) {
                osw.write(jsonInputString);
                osw.flush();
            }

            // 获取响应码
            int responseCode = connection.getResponseCode();

            if (responseCode == 200) {
                // 请求成功
                System.out.println("POST request was successful.");
            } else {
                // 请求失败
                System.out.println("POST request failed with response code: " + responseCode);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
