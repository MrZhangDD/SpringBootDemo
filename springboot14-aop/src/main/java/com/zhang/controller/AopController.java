package com.zhang.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {
    private static Logger logger = Logger.getLogger(AopController.class);

    @RequestMapping("/aop")
    public String aop1(){
        logger.info("执行方法--hao");
        return "aop";
    }
}
