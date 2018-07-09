package com.wu.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wu on 2018/7/9.
 */
public class Logger implements Serializable {

    private String logId;
    private String logUser;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date logTime;
    private String logResource;
    private String logAction;
    private String logMessage;
    private String logResult;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogResource() {
        return logResource;
    }

    public void setLogResource(String logResource) {
        this.logResource = logResource;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }

    public Logger(String logId, String logUser, String logResource, String logAction, String logMessage, String logResult) {
        this.logId = logId;
        this.logUser = logUser;
        this.logResource = logResource;
        this.logAction = logAction;
        this.logMessage = logMessage;
        this.logResult = logResult;
    }

    public Logger() {
    }

    @Override
    public String toString() {
        return "Logger{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logTime=" + logTime +
                ", logResource='" + logResource + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logMessage='" + logMessage + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }
}
