package com.wy;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;


/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/10/30
 */
public class HttpProxy {
    public static void main(String[] args) {
        String url = "http://10.57.17.244:8044/api/routes/ok";
        String json = "{\"target\": \"http://10.57.17.\"}";

        HttpRequest.post(url).body(json).header("Content-Type", "application/json").execute();
    }


}
