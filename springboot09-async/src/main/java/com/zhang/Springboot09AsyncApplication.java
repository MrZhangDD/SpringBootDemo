package com.zhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Springboot09AsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsyncApplication.class, args);
    }

}
