package com.wy.global;

import cn.hutool.core.io.FileUtil;

import cn.hutool.poi.excel.ExcelUtil;
import com.wy.global.handler.GlobalizeHandler;
import com.wy.mycode.ExcelUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;

/**
 * @author HelloWorld
 * @date 2023/9/1 12:34
 * @email helloworld.dng@gmail.com
 */

@Slf4j
public class AutoGlobalizationUtil {
    private static final String CODE_TYPE_UTF8 = "UTF-8";

    private static List<String> ERROR_LOG_LIST = new ArrayList<>();

    private static List<List<String>> SHOULD_GLOBAL_FILE_LIST = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String filePath = GlobalizeHandler.getGlobalizeConfig().getProjectPath();
        traverseFolder(new File(filePath));
        System.exit(1);
    }

    public static void traverseFolder(File inputFile) throws Exception {
        Stack<File> fileStack = new Stack<>();
        fileStack.push(inputFile);

        while (!fileStack.isEmpty()) {
            File popFile = fileStack.pop();
            for (File file : popFile.listFiles()) {
                if (file.isDirectory()) {
                    fileStack.push(file);
                } else {
                    //globalizeJava(file);
                    logShouldGlobalFile(file);
                }
            }
        }

        //GlobalizeHandler.writeFile(ERROR_LOG_LIST);
        GlobalizeHandler.writeInfoLog(SHOULD_GLOBAL_FILE_LIST);
    }

    private static void logShouldGlobalFile(File file) {
        String fileName = file.getName();

        if (!fileName.endsWith(".java")) {
            return;
        }

        int lineNum = 0;
        for (String line : FileUtil.readLines(file, CODE_TYPE_UTF8)) {
            lineNum++;
            if (isNotCode(line)) {
                continue;
            }
            Matcher matcher = GlobalizeHandler.chinesePattern.matcher(line);
            if (matcher.find()) {
                if (!line.contains("\"")) {
                    continue;
                }
                if (line.length() > 999) {
                    line = line.substring(0, 100);
                }
                ArrayList<String> tempInfoList = new ArrayList<>();
                tempInfoList.add(fileName);
                tempInfoList.add(String.valueOf(lineNum));
                tempInfoList.add(line.trim());
                SHOULD_GLOBAL_FILE_LIST.add(tempInfoList);
            }
        }
    }

    private static boolean isNotCode(String line) {
        line = line.trim();
        if (line.startsWith("//")) {
            return true;
        }

        if (line.startsWith("*")) {
            return true;
        }

        // swagger文档不需要国际化
        if (line.startsWith("@Api")) {
            return true;
        }
        return false;
    }

    private static void globalizeJava(File file)  {
        if (!file.getName().endsWith(".java")) {
            return;
        }

        System.out.println((file.getName() + "国际化处理 start"));
        List<String> result = new ArrayList<>();
        int lineNum = 1;
        for (String line : FileUtil.readLines(file, CODE_TYPE_UTF8)) {
            try {
                line = GlobalizeHandler.handler(line);
            } catch (Exception e) {
                String errorMsg = String.format("ERROR!!! %s 第 %s 行国际化异常", file.getName(), lineNum);
                System.out.println(errorMsg);
                ERROR_LOG_LIST.add(String.format("%s, 原因是：%s", errorMsg, e));
            }
            result.add(line);
            lineNum++;
        }

        if (GlobalizeHandler.isShouldGlobalizeFlag()) {
            FileUtil.writeLines(result, file, CODE_TYPE_UTF8);
            System.out.println((file.getName() + "国际化处理 end"));
        } else {
            System.out.println((file.getName() + "不需要国际化处理"));
        }
    }

}
