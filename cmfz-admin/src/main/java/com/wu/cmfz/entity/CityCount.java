package com.wu.cmfz.entity;

import java.io.Serializable;

/**
 * Created by wu on 2018/7/9.
 */
public class CityCount implements Serializable{
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public CityCount() {
    }

    public CityCount(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
