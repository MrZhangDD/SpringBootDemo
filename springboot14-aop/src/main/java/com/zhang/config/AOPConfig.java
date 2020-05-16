package com.zhang.config;

import org.apache.log4j.Logger;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 一直报包不存 -- 未解决
 */
@Component //放入到IOC容器中
@Aspect //声明切面类
public class AOPConfig {
   private static Logger logger = Logger.getLogger(AOPConfig.class);
    @Pointcut("execution(public * com.zhang.controller.*.*(..))")
    public void webLog(){}

    /**
     * 前置通知
     */
    @Before("webLog()")
    public void doBefore(){
        System.out.println("-------");
    }


}
