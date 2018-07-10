package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zxl on 2018/7/10.
 */
@Aspect
@Component
public class AspectJController {
    @Autowired
    private LogService ls;
    @Autowired
    private HttpSession session;

    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.add*(..))||execution(* com.baizhi.cmfz.service.impl.*.romve*(..))||execution(* com.baizhi.cmfz.service.impl.*.modify*(..))")
    public void point(){}

    @Around("point()")
    public Object around(ProceedingJoinPoint pjp){
        Log log=new Log();
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            log.setLogResult("error");
            throwable.printStackTrace();
        }
        log.setLogResult("success");
        Object[] args=pjp.getArgs();
        String message="";
        for (Object str:args) {
            message=message+str.toString();
        }
        MethodSignature methodSignature= (MethodSignature) pjp.getSignature();
        Method method=methodSignature.getMethod();
        String methodName=method.getName();
        String className=methodSignature.getDeclaringType().getSimpleName();
        String resource=className.replace("Service","");
        String name="";
        Manager manager =(Manager)session.getAttribute("manager");
        String userName=manager.getName();
        if(methodName.startsWith("add")){
            name="新增";
        }else if(methodName.startsWith("remove")){
            name="删除";
        }else if(methodName.startsWith("modify")){
            name="修改";
        }
        String id= UUID.randomUUID().toString().replace("-","");

        log.setLogId(id);
        log.setLogMessage(message);
        log.setLogTime(new Date());
        log.setLogAction(name);
        log.setLogResource(resource);
        log.setLogUser(userName);
        ls.insertLog(log);
        return obj;

    }
}
