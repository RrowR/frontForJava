package com.study.back.project;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.study.back.project.mapper")
@SpringBootApplication
public class BackProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackProjectApplication.class, args);
    }

}
