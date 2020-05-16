package com.zhang.controller;

import com.zhang.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ResponseBody
    @GetMapping("/hello1")
    public String hello1(){
        return "hello";
    }

    @ApiOperation("调用用户")
    @PostMapping("/user")
    public User user(@ApiParam("用户参数") User user){
        return new User();
    }

}
