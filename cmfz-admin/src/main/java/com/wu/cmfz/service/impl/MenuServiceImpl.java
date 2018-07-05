package com.wu.cmfz.service.impl;

import com.wu.cmfz.dao.MenuDao;
import com.wu.cmfz.entity.Menu;
import com.wu.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wu on 2018/7/5.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuDao menuDao;

    @Override
    @Transactional( propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Menu> queryAllMenu() {
        List<Menu> menus = menuDao.selectMenu();
        return menus;
    }

    @Override
    public boolean modifyMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean removeMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean addMenu(Menu menu) {
        return false;
    }
}
