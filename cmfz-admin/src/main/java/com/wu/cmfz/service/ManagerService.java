package com.wu.cmfz.service;

import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.entity.MgrPermission;
import com.wu.cmfz.entity.MgrRole;

import java.util.List;

/**
 * Created by wu on 2018/7/4.
 */
public interface ManagerService{
    public Manager queryManagerByName(String name);
    public boolean modifyManager(Manager manager);
    public boolean removeManager(Manager manager);
    public boolean addManager(Manager manager);

    public List<MgrRole> queryRolesByName(String name);
    public List<MgrPermission> queryPermissionByName(String name);
}
