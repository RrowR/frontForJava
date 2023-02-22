package com.study.back.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class BackProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackProjectApplication.class, args);
    }

}
