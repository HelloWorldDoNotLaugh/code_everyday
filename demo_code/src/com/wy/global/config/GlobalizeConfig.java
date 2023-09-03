package com.wy.global.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HelloWorld
 * @date 2023/9/2 16:45
 * @email helloworld.dng@gmail.com
 */
public class GlobalizeConfig {

    private List<String> shouldGlobalFactorList;

    private String projectPath;
    private String messagesPath;

    private String messagesCnPath;

    private String messagesEnPath;

    private String localeMessageEnumPath;

    private String errorLogPath;

    public List<String> getShouldGlobalFactorList() {
        return shouldGlobalFactorList;
    }

    public void setShouldGlobalFactorList(ArrayList<String> shouldGlobalFactorList) {
        this.shouldGlobalFactorList = shouldGlobalFactorList;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getMessagesPath() {
        return messagesPath;
    }

    public void setMessagesPath(String messagesPath) {
        this.messagesPath = messagesPath;
    }

    public String getMessagesCnPath() {
        return messagesCnPath;
    }

    public void setMessagesCnPath(String messagesCnPath) {
        this.messagesCnPath = messagesCnPath;
    }

    public String getMessagesEnPath() {
        return messagesEnPath;
    }

    public void setMessagesEnPath(String messagesEnPath) {
        this.messagesEnPath = messagesEnPath;
    }

    public String getLocaleMessageEnumPath() {
        return localeMessageEnumPath;
    }

    public void setLocaleMessageEnumPath(String localeMessageEnumPath) {
        this.localeMessageEnumPath = localeMessageEnumPath;
    }

    public String getErrorLogPath() {
        return errorLogPath;
    }

    public void setErrorLogPath(String errorLogPath) {
        this.errorLogPath = errorLogPath;
    }
}
