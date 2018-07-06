package com.wu.test;

import com.wu.cmfz.dao.ManagerDao;
import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.entity.Menu;
import com.wu.cmfz.entity.Picture;
import com.wu.cmfz.service.ManagerService;
import com.wu.cmfz.service.MasterService;
import com.wu.cmfz.service.MenuService;
import com.wu.cmfz.service.PictureService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Created by wu on 2018/7/4.
 */
public class TestCookie {

    @Test
    public void test1() throws UnsupportedEncodingException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService = (ManagerService) applicationContext.getBean("managerServiceImpl");
        Manager manager = managerService.queryManagerByName("吴","123456");
        System.out.println(manager);

    }

    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ManagerService managerService = (ManagerService) applicationContext.getBean("managerServiceImpl");
        boolean manager = managerService.addManager(new Manager());
        System.out.println(manager);
    }

    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MenuService serviceImpl = (MenuService) applicationContext.getBean("menuServiceImpl");
        List<Menu> menus = serviceImpl.queryAllMenu();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }



    @Test
    public void test5(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        PictureService pictureService = (PictureService) applicationContext.getBean("pictureServiceImpl");
        Map<String, Object> stringObjectMap = pictureService.queryAllPic(2, 1);
        for (Object s : stringObjectMap.entrySet()) {
            System.out.println(s);
        }
    }

    @Test
    public void test6(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        MasterService masterService =  (MasterService)applicationContext.getBean("masterServiceImpl");
        Map<String, Object> stringObjectMap = masterService.queryMaster(1,1,null,null);
        for (Object s : stringObjectMap.entrySet()) {
            System.out.println(s);
        }
    }

   

}
