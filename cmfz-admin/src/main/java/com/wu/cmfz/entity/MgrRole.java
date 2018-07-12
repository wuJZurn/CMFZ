package com.wu.cmfz.entity;

import java.io.Serializable;

/**
 * Created by wu on 2018/7/12.
 */
public class MgrRole implements Serializable {
    private int roleId;
    private String roleName;
    private String roleTag;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    @Override
    public String toString() {
        return "MgrRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }

    public MgrRole(int roleId, String roleName, String roleTag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }

    public MgrRole() {
    }
}
