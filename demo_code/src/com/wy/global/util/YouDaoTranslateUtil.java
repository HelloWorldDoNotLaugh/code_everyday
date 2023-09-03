package com.wy.global.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wy.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author HelloWorld
 * @date 2023/9/1 16:23
 * @email helloworld.dng@gmail.com
 */

@Slf4j
public class YouDaoTranslateUtil {
    private static final String APP_KEY = "4b7128474f5adf98";     // 您的应用ID
    private static final String APP_SECRET = "432tthwj1Dt0JgKOqZvYOApBLJbXmTwc";  // 您的应用密钥

    private static final Pattern englishPattern = Pattern.compile("[A-Za-z\\s']+");

    private static Pattern pattern = Pattern.compile("[^\\p{IsLetter}\\p{IsDigit}]+");


    public static String translateCN2EN(String info) throws NoSuchAlgorithmException {
        System.out.println((info + " 请求有道云API start"));
        Matcher matcher1 = pattern.matcher(info);
        info = matcher1.replaceAll("");
        // 添加请求参数
        Map<String, String[]> params = createRequestParams();
        params.put("q", new String[]{info});
        // 添加鉴权相关参数
        AuthV3Util.addAuthParams(APP_KEY, APP_SECRET, params);
        // 请求api服务
        byte[] result = HttpUtil.doPost("https://openapi.youdao.com/api", null, params, "application/json");
        // 打印返回结果
        if (result != null) {
            JSONObject jsonObject = JSON.parseObject(new String(result, StandardCharsets.UTF_8));
            Matcher matcher = englishPattern.matcher(jsonObject.get("translation").toString());
            if (matcher.find()) {
                System.out.println((info + " 请求有道云API end; 译文为：" + matcher.group()));
                return matcher.group();
            }
        }
        System.out.println((info + " 请求有道云API end; 请求异常"));
        throw new RuntimeException("有道云翻译异常");
    }
    private static Map<String, String[]> createRequestParams() {
        /*
         * note: 将下列变量替换为需要请求的参数
         * 取值参考文档: https://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html
         */
//        String q = "今天天气怎么样";
        String from = "zh-CHS";
        String to = "en";
        String domain = "computers";

        return new HashMap<String, String[]>() {{
            //put("q", new String[]{q});
            put("from", new String[]{from});
            put("to", new String[]{to});
            put("domain", new String[]{domain});
        }};
    }
}
