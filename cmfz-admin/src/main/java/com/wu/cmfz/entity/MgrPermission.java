package com.wu.cmfz.entity;

import java.io.Serializable;

/**
 * Created by wu on 2018/7/12.
 */
public class MgrPermission implements Serializable {

    private int permissionId;
    private String resourceName;
    private String resourceTag;
    private String resourceUrl;
    private String permissionTag;

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    @Override
    public String toString() {
        return "MgrPermission{" +
                "permissionId=" + permissionId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }

    public MgrPermission(int permissionId, String resourceName, String resourceTag, String resourceUrl, String permissionTag) {
        this.permissionId = permissionId;
        this.resourceName = resourceName;
        this.resourceTag = resourceTag;
        this.resourceUrl = resourceUrl;
        this.permissionTag = permissionTag;
    }

    public MgrPermission() {
    }
}
