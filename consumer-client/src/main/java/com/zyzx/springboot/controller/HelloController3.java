package com.zyzx.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName HelloController3
 * @Description TODO
 * @Author DELL
 * @Version V1.0
 */
@RestController
public class HelloController3 {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name){
        //直接访问生产者
//        String url = "http://localhost:7900/hello";
//        return this.restTemplate.getForObject(url, String.class);

        //负载均衡
        String url = "http://provider-user/hello/" + name;
        return this.restTemplate.getForObject(url, String.class);
    }
}
