package com.zyzx.springboot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController2
 * @Description TODO
 * @Author DELL
 * @Version V1.0
 */
@RestController
public class HelloController2 {

    @RequestMapping("/hello/{name}")
    public String hellow2(@PathVariable String name){
        return "2:" + name;
    }
}
