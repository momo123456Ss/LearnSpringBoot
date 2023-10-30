package com.hht.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "com.hht.springboot.controller",
    "com.hht.springboot.repository",
    "com.hht.springboot.service",
    "com.hht.springboot.formatters",
    "com.hht.springboot.configs",
    "com.hht.springboot.components",
    "com.hht.springboot.filters"
})
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
