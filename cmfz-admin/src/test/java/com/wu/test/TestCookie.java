package com.wu.test;

import com.wu.cmfz.dao.ManagerDao;
import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.service.ManagerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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

}
