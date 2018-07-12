package com.wu.cmfz.service.impl;

import com.wu.cmfz.dao.ManagerDao;
import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.entity.MgrPermission;
import com.wu.cmfz.entity.MgrRole;
import com.wu.cmfz.service.ManagerService;
import com.wu.cmfz.utils.EncryptionUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * service实现类
 * 管理员信息
 * Created by wu on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerDao managerDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Manager queryManagerByName(String name) {
        return managerDao.selectByName(name);
       /* String password= DigestUtils.md5Hex(pwd+manager.getSalt());
        System.out.println(pwd);
        if(manager.getMgrPwd().equals(pwd)){
            return manager;
        }
        return null;*/
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

       /* manager.setMgrId(333);
        manager.setMgrName("lalal");
        manager.setMgrPwd("123123");
        manager.setMgrStatus("1");

        String salt= EncryptionUtils.getRandomSalt(6);
        manager.setSalt(salt);
        try {
            manager.setMgrPwd(EncryptionUtils.encryption(manager.getMgrPwd()+salt));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        System.out.println(manager);*/

        manager.setMgrId(3);
        manager.setSalt("xyz");
        manager.setMgrStatus("1");
        manager.setMgrName("admin");
        Md5Hash md5Hash = new Md5Hash("123456", "xyz",1024);
        manager.setMgrPwd(String.valueOf(md5Hash));
        boolean a=managerDao.insertManager(manager);

        return a;
    }

    @Override
    public List<MgrRole> queryRolesByName(String name) {
        return managerDao.findRolesByName(name);
    }

    @Override
    public List<MgrPermission> queryPermissionByName(String name) {
        return managerDao.findPremissionByName(name);
    }
}
