package com.wu.cmfz.controller;

import com.wu.cmfz.entity.Menu;
import com.wu.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wu on 2018/7/5.
 */
@Controller
@RequestMapping("/menu")
public class MainController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenu")
    @ResponseBody
    public List<Menu> getMenu(){
        List<Menu> menus = menuService.queryAllMenu();
        return menus;
    }

    
}
