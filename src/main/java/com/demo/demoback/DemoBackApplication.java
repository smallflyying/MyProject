package com.demo.demoback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.demo.demoback.mapper")
public class DemoBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoBackApplication.class, args);
    }

}
