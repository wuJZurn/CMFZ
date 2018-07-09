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
 * 管理员Controller类
 * Created by wu on 2018/7/4.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/login")
    public String loginManger(String managerName, String password, String code,String checkName, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();

        String vcode=(String) session.getAttribute("code");

        if(code.isEmpty() || !vcode.equalsIgnoreCase(code)){
            return "login";
        }
        Manager manager = managerService.queryManagerByName(managerName,password);

        if(manager!=null){
            if(checkName!=null){
                Cookie cookie =new Cookie("checkName",URLEncoder.encode(managerName,"UTF-8"));
                cookie.setMaxAge(2400);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
            if(checkName==null){
                Cookie cookie = new Cookie("checkName",null);
                cookie.setMaxAge(0);
                cookie.setPath("/");
                response.addCookie(cookie);
            }

            session.setAttribute("user",managerName);
            return "main/main";
        }


        return "login";
    }
}
