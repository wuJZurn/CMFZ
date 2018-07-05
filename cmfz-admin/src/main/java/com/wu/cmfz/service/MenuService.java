package com.wu.cmfz.service;

import com.wu.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by wu on 2018/7/5.
 */
public interface MenuService {
    public List<Menu> queryAllMenu();
    public boolean modifyMenu(Menu menu);
    public boolean removeMenu(Menu menu);
    public boolean addMenu(Menu menu);
}
