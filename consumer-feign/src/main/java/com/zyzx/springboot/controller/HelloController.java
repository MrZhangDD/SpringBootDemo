package com.zyzx.springboot.controller;

import com.zyzx.springboot.EurekaServiceFeigns;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private EurekaServiceFeigns eurekaServiceFeigns;
    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return eurekaServiceFeigns.hello(name);
    }
}
