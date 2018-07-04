package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Manager;

/**
 * Created by wu on 2018/7/4.
 */
public interface ManagerDao {
    public Manager selectByName(String name);
    public boolean updateManager(Manager manager);
    public boolean deleteManager(Manager manager);
    public boolean insertManager(Manager manager);
}
