package com.dashui.naruto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.dashui.naruto.mapper")
public class NarutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(NarutoApplication.class, args);
    }

}
