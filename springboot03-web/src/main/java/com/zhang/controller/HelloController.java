package com.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HelloController {
    @RequestMapping("/test1")
    public String test1(){
        return "hello";
    }

    @RequestMapping("/test2")
    public String test2(Model model){
        model.addAttribute("msg","thymeleaf");
        return "thymeleaf1";
    }

    @RequestMapping("/test3")
    public String test3(Model model){
        model.addAttribute("users", Arrays.asList("zhang","li"));
        return "thymeleaf1";
    }

}
