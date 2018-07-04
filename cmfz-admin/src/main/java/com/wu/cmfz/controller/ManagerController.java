package com.wu.cmfz.controller;

import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by wu on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String loginManger(String managerName, String password, String code,String checkName, HttpServletResponse response, HttpServletRequest request){
        HttpSession session = request.getSession();

        String vcode=(String) session.getAttribute("code");

        if(code.isEmpty() || !vcode.equalsIgnoreCase(code)){
            return "login";
        }
        Manager manager = managerService.queryManagerByName(managerName,password);

        if(manager!=null){
            if(checkName!=null){
                System.out.println("true");
            }
            return "index";
        }
        return "login";
    }
}
