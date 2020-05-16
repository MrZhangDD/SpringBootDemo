package com.zhang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.Map;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "person")  //爆红不会影响程序运行
//@PropertySource(value = "classpath:zhang.properties")  //加载指定properties
//@Validated

public class Person {
    //@Value("${name}")
    //@Email()
    private String name;
    private String sex;
    private Integer age;
    private Date birthdy;
    private Map<String,Object> map;
    private Dog dog;

}
