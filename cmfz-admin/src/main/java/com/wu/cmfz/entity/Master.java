package com.wu.cmfz.entity;


import org.jeecgframework.poi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by wu on 2018/7/6.
 */
public class Master implements Serializable{
    private int masterId;
    @Excel(name="上师姓名",orderNum = "1",needMerge = true)
    private String masterName;
    @Excel(name="上师简介",orderNum = "2",needMerge = true)
    private String masterSummary;
    private String masterPhoto;

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummary() {
        return masterSummary;
    }

    public void setMasterSummary(String masterSummary) {
        this.masterSummary = masterSummary;
    }

    public Master(String masterName, String masterPhoto, String masterSummary) {
        this.masterName = masterName;
        this.masterPhoto = masterPhoto;
        this.masterSummary = masterSummary;
    }

    public Master() {
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId=" + masterId +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummary='" + masterSummary + '\'' +
                '}';
    }
}
