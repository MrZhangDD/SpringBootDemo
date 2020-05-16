package com.zhang.config;

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

//国际化写好之后需要放入容器中 @Bean
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //解析请求中的参数
        String key = request.getParameter("l");
        Locale aDefault = Locale.getDefault();
        if(!StringUtils.isEmpty(key)){
            String[] split = StringUtils.split(key, "_");
            aDefault = new Locale(split[0],split[1]);
        }
        return aDefault;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
