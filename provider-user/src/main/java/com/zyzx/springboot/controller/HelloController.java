package com.zyzx.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author DELL
 * @Version V1.0
 */
@RestController
public class HelloController {
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "1:" + name;
    }
}
