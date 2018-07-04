package com.wu.cmfz.controller;

import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by wu on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String loginManger(String managerName, String password, String code,String checkName, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        System.out.println(managerName+" "+password);
        managerName= URLEncoder.encode(managerName,"UTF-8");
        HttpSession session = request.getSession();

        String vcode=(String) session.getAttribute("code");

        if(code.isEmpty() || !vcode.equalsIgnoreCase(code)){
            return "login";
        }
        Manager manager = managerService.queryManagerByName(managerName,password);

        if(manager!=null){
            if(checkName!=null){
                Cookie cookie =new Cookie("checkName",managerName);
                cookie.setMaxAge(60*60);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            return "index";
        }
        return "login";
    }
}
