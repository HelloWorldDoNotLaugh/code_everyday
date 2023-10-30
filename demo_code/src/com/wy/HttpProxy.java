package com.wy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

import java.util.HashMap;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/10/30
 */
public class HttpProxy {
    public static void main(String[] args) {
        String url = "http://localhost:8002/api/routes/mingmo";
        String json = "{\"target\": \"https://modelwise.tcloud.tongdun.cn/user/login\"}";

        HttpRequest.post(url).body(json).header("Content-Type", "application/json").execute();
    }
}
