package com.wu.cmfz.service.impl;

import com.wu.cmfz.dao.ManagerDao;
import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wu on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDao managerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Manager queryManagerByName(String name, String pwd) {
        Manager manager = managerDao.selectByName(name);
        if(manager.getMgrPwd().equals(pwd)){
            return manager;
        }
        return null;
    }

    @Override
    public boolean modifyManager(Manager manager) {
        return false;
    }

    @Override
    public boolean removeManager(Manager manager) {
        return false;
    }

    @Override
    public boolean addManager(Manager manager) {
        return false;
    }
}
