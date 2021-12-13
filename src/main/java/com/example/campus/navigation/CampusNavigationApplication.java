package com.example.campus.navigation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.campus.navigation.mapper")
public class CampusNavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusNavigationApplication.class, args);
    }

}
