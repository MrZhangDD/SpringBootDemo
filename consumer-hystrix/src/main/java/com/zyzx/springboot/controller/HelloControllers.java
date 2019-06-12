package com.zyzx.springboot.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyzx.springboot.EurekaServiceFeign;
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
public class HelloControllers {

    @Autowired
    private EurekaServiceFeign eurekaServiceFeign;
    @RequestMapping("/hello/{name}")
    @HystrixCommand(fallbackMethod = "helloFallback")//作用是断路后返回统一默认值
    public String hello(@PathVariable String name){
        return eurekaServiceFeign.hello(name);
    }

    //此方法名和上面的@HystrixCommand(fallbackMethod = "helloFallback")一致
    public String helloFallback(String name){
        return "调用失败返回默认值";
    }
}
