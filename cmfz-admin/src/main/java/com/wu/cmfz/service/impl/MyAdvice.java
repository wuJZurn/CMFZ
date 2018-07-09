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
    public Object around(ProceedingJoinPoint pjd){
        Object obj=null;
        String id=null;
        String user=null;
        String action = null;
        String resource=null;
        String message=null;
        String resTT="false";
        try {
            obj = pjd.proceed();
            id= UUID.randomUUID().toString().replace("-","");
            //HttpSession session=null;
            //String
            HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session =request.getSession();
            user = (String) session.getAttribute("user");

            MethodSignature methodSignature = (MethodSignature) pjd.getSignature();
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
            Object[] args = pjd.getArgs();
            String message1=args[0].toString();
            message=message1.replaceAll("\'","\\\\'");
            resTT="success";
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        LoggerService loggerService =  (LoggerService)applicationContext.getBean("loggerServiceImpl");
        Logger logger=new Logger(id,user,resource,action,message,resTT);
        loggerService.insertLogger(logger);
        return obj;
    }
}
