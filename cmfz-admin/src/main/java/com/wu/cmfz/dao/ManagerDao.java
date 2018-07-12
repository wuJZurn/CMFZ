package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.entity.MgrPermission;
import com.wu.cmfz.entity.MgrRole;

import java.util.List;

/**
 * Created by wu on 2018/7/4.
 */
public interface ManagerDao {
    public Manager selectByName(String name);
    public boolean updateManager(Manager manager);
    public boolean deleteManager(Manager manager);
    public boolean insertManager(Manager manager);

    public List<MgrRole> findRolesByName(String name);
    public List<MgrPermission> findPremissionByName(String name);
}
