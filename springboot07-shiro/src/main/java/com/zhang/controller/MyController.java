package com.zhang.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","hello shiro");
        return "index";
    }

    @RequestMapping("/user/add")
    public String add(){
        return "/views/add";
    }

    @RequestMapping("/user/update")
    public String update(){
        return "/views/update";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/views/login";
    }

    @RequestMapping("/login")
    public String login(String user, String pwd, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user,pwd);
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名不正确");
            return "/views/login";
        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg","密码不正确");
            return "/views/login";
        }
    }
    @RequestMapping("/unlogin")
    public String unlogin() {
        return "/views/unlogin";
    }

}
