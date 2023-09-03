package com.wy.global;

import cn.hutool.core.io.FileUtil;

import com.wy.global.handler.GlobalizeHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

/**
 * @author HelloWorld
 * @date 2023/9/1 12:34
 * @email helloworld.dng@gmail.com
 */

@Slf4j
public class AutoGlobalizationUtil {
    private static final String CODE_TYPE_UTF8 = "UTF-8";

    private static List<String> ERROR_LOG_LIST = new ArrayList<>();

    public static void main(String[] args) {
        String filePath = GlobalizeHandler.getGlobalizeConfig().getProjectPath();
        traverseFolder(new File(filePath));
        System.exit(1);
    }

    public static void traverseFolder(File inputFile) {
        Stack<File> fileStack = new Stack<>();
        fileStack.push(inputFile);

        while (!fileStack.isEmpty()) {
            File popFile = fileStack.pop();
            for (File file : popFile.listFiles()) {
                if (file.isDirectory()) {
                    fileStack.push(file);
                } else {
                    globalizeJava(file);
                }
            }
        }

        GlobalizeHandler.writeFile(ERROR_LOG_LIST);
    }

    private static void globalizeJava(File file)  {
        if (!file.getName().endsWith(".java")) {
            return;
        }

        System.out.println((file.getName() + "国际化处理 start"));
        List<String> result = new ArrayList<>();

        for (String line : FileUtil.readLines(file, CODE_TYPE_UTF8)) {
            try {
                line = GlobalizeHandler.handler(line);
            } catch (Exception e) {
                System.out.println("ERROR!!!" + file.getName() + "国际化异常");
                ERROR_LOG_LIST.add(file.getName() + "国际化异常: " + e.getMessage());
            }
            result.add(line);
        }

        if (GlobalizeHandler.isShouldGlobalizeFlag()) {
            FileUtil.writeLines(result, file, CODE_TYPE_UTF8);
            System.out.println((file.getName() + "国际化处理 end"));
        } else {
            System.out.println((file.getName() + "不需要国际化处理"));
        }
    }

}
