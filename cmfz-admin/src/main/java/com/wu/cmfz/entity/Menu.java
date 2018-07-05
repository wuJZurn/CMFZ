package com.wu.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wu on 2018/7/5.
 */
public class Menu implements Serializable{

    private int menuId;
    private String menuName;
    private String menuCode;
    private String menuIcon;
    private String menuUrl;
    private String menuParentId;
    private String menuLevel;
    private List<Menu> secondMenuList;

    public List<Menu> getSecondMenuList() {
        return secondMenuList;
    }

    public void setSecondMenuList(List<Menu> secondMenuList) {
        this.secondMenuList = secondMenuList;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(String menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public Menu(String menuName, String menuCode, String menuIcon, String menuUrl, String menuParentId, String menuLevel) {
        this.menuName = menuName;
        this.menuCode = menuCode;
        this.menuIcon = menuIcon;
        this.menuUrl = menuUrl;
        this.menuParentId = menuParentId;
        this.menuLevel = menuLevel;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", menuCode='" + menuCode + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", menuParentId='" + menuParentId + '\'' +
                ", menuLevel='" + menuLevel + '\'' +
                ", secondMenuList=" + secondMenuList +
                '}';
    }
}
