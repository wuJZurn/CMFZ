package com.wu.cmfz.service.impl;

import com.wu.cmfz.entity.Logger;
import com.wu.cmfz.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by wu on 2018/7/9.
 */

@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.wu.cmfz.service.impl.*.add*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        Object obj=null;
        String action = null;
        String resource=null;
        String resTT="false";
        String id= UUID.randomUUID().toString().replace("-","");
        //HttpSession session=null;
        //String
        HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session =request.getSession();
        String user = (String) session.getAttribute("user");

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method =methodSignature.getMethod();
        String name = method.getName();

        if(name.contains("add")){
            action = "add";
            resource=name.replace("add","");
        }
        if(name.contains("modify")){
            action ="modify";
            resource=name.replace("modify","");
        }


        StringBuilder message1 = new StringBuilder();

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            message1.append(arg+";");
        }
        String message=message1.toString();
        try {
            obj = pjp.proceed();
            resTT="success";
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
            LoggerService loggerService =  (LoggerService)applicationContext.getBean("loggerServiceImpl");
            Logger logger=new Logger(id,user,resource,action,message,resTT);
            loggerService.insertLogger(logger);
            return obj;
        }
    }
}
