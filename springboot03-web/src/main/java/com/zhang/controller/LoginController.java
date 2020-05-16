package com.zhang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    //@RequestParam 接收url传过来的参数
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model, HttpSession httpSession){
        if(!StringUtils.isEmpty(username) && StringUtils.equals("123",password)){
            httpSession.setAttribute("loginUser",username);
            return "redirect:main.html";
        }
        String msg = "用户名或密码错误!";
        model.addAttribute("msg",msg);
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:index.html";
    }

}
