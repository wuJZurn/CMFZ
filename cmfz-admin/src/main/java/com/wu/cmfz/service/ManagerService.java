package com.wu.cmfz.service;

import com.wu.cmfz.entity.Manager;

/**
 * Created by wu on 2018/7/4.
 */
public interface ManagerService{
    public Manager queryManagerByName(String name,String pwd);
    public boolean modifyManager(Manager manager);
    public boolean removeManager(Manager manager);
    public boolean addManager(Manager manager);
}
