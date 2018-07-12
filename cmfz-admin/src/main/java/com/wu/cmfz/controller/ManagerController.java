package com.wu.cmfz.controller;

import com.wu.cmfz.entity.Manager;
import com.wu.cmfz.service.ManagerService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public String loginManger(String managerName, String password, String code,String checkName,boolean rememberMe,HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        HttpSession session = request.getSession();

        String vcode=(String) session.getAttribute("code");

        if(code.isEmpty() || !vcode.equalsIgnoreCase(code)){
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(managerName,password,rememberMe));
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
        } catch (AuthenticationException e) {
            System.out.println("认证失败");
            e.printStackTrace();
            return "login";
        }
    }


    @RequestMapping("/logoutManager")
    public String logoutManager(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
