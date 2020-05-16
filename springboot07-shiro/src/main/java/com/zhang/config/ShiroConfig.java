package com.zhang.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    //shiroFillterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        /**
         * anon:无需认证
         * authc：必须认证
         * user：必须拥有记住我才能使用
         * perms：拥有对某个资源的权限才能使用
         * role：拥有某个角色才能访问
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/user/add","perms[user:add]");//必须得放在上面
        filterChainDefinitionMap.put("/user/update","perms[user:update]");//必须得放在上面
        //filterChainDefinitionMap.put("/user/*","authc"); //授权
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //设置登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        //未授权页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unlogin");
        return shiroFilterFactoryBean;
    }

    //DefaultWebSecurityManager
    //@Qualifier("userRealm")  bean name注入
    @Bean("securityManager")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //realm
    //创建realm对象
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合shiroDialect
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
