package com.dashui.naruto;

import cn.dev33.satoken.SaManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class NarutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(NarutoApplication.class, args);
    }

}
