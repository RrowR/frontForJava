package com.study.elementadmin.background;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: Rrow
 * @date: 2023/5/20 15:03
 * Description:
 */
@SpringBootApplication
public class ElementAdminApplication implements WebMvcConfigurer {
    @Bean
    public com.itheima.controller.LoginInterceptor loginInterceptor() {
        return new com.itheima.controller.LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/**");
    }

    @Value("${frontend.url}")
    private String frontendUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(frontendUrl)
                .allowedMethods("OPTIONS", "GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }

    public static void main(String[] args) {
        SpringApplication.run(ElementAdminApplication.class, args);
    }
}
