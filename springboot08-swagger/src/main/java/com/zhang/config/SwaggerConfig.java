package com.zhang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //分组
    @Bean
    //配合swagger的docket的bean实例
    public Docket docket1(Environment environment){
        //获取当前环境来决定是否激活swagger
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    //配合swagger的docket的bean实例
    public Docket docket2(Environment environment){
        //获取当前环境来决定是否激活swagger
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    //配合swagger的docket的bean实例
    public Docket docket(Environment environment){
        //获取当前环境来决定是否激活swagger
        Profiles profile = Profiles.of("dev","test");
        boolean b = environment.acceptsProfiles(profile);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(b) // 是否开启swagger
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zhang.controller")) //扫描指定包
                .build().groupName("zhang");
    }

    @Bean
    public ApiInfo apiInfo(){
        Contact contact = new Contact("学习", "http://192.168.16.1/login.asp", "1165889196@qq.com");
        return new ApiInfo(
                "Api 张",
                "学习日记",
                "1.0",
                "https://www.baidu.com/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }

}
