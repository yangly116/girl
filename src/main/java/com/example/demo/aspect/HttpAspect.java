package com.example.demo.aspect;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Pointcut("execution(public * com.example.demo.controller.GirlController.*(..))")
    public void log(){
        logger.info("11111111111111111111111");
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //class
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //args
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log()")
    public void doAfter(){
        logger.info("22222222222222222222222");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
//    @After("execution(public * com.example.demo.controller.GirlController.*(..))")
//    public void doAfter(){
//        logger.info("22222222222222222222222");
//    }
}
