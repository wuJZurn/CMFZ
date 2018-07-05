package com.wu.cmfz.dao;

import com.wu.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by wu on 2018/7/5.
 */
public interface MenuDao {
    public List<Menu> selectMenu();
    public boolean insertMenu(Menu menu);
    public boolean updateMenu(Menu menu);
    public boolean deleteMenu(Menu menu);
}
