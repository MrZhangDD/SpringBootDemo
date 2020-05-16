package com.zhang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 配置角色
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/level1/**").hasRole("vip1")
                .mvcMatchers("/level2/**").hasRole("vip2")
                .mvcMatchers("/level3/**").hasRole("vip3");
        http.formLogin()//没有权限跳转到登录页面
                .loginPage("/toLogin").usernameParameter("user").passwordParameter("pwd").loginProcessingUrl("/login"); //定制自己的登录页面

        //注销功能
        http.csrf().disable();//禁用csrf过滤功能
        http.logout().logoutSuccessUrl("/");
        //开启记住我功能.默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }

    /**
     * 内存中存储用户信息，定制认证规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("zhang").password(new BCryptPasswordEncoder().encode("123456")).roles("vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
    }
}
