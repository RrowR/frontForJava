package com.study.back.project.controller;

import com.study.back.project.bean.Nya;
import com.study.back.project.bean.Student;
import com.study.back.project.bean.User;
import com.study.back.project.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author: Rrow
 * @date: 2023/2/22 19:48
 * Description:
 */
@RestController
public class MyController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/toback")
    public String toback(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "成功";
    }

    @PostMapping("/toBean")
    public String toBean(User user, MultipartFile avatar) throws IOException {  // RequestBoby需要前端传json
        System.out.println("user = " + user);
        System.out.println("avatar.getName() = " + avatar.getOriginalFilename());
        byte[] bytes = avatar.getBytes();
        System.out.println("bytes.length = " + bytes.length);
        return "成功";
    }

    @GetMapping("/test")
    public String getMethod(String name) {
        System.out.println("name = " + name);
        return "success";
    }

    @PostMapping("/test")
    public String postMethod(String name) {
        System.out.println("name = " + name);
        return "success";
    }

    @RequestMapping("/page")
    @ResponseBody
    public void page(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
    }

    // 返回学生数据的接口
    // @CrossOrigin("http://localhost:7070")
    @GetMapping("/api/getStudent")
    public Object getStudent() {
        List<Student> students = studentMapper.selectList(null);
        return students;
    }

    @GetMapping("/api/get01")
    public String get01() {
        return "request mapping";
    }

    @PostMapping("/api/post01")
    public String post01() {
        return "post mapping";
    }

    // 获取请求头的接口
    @PostMapping("/api/post02")
    public String post02(@RequestHeader("Authorization") String authorization) {
        return "post with header authorization is " + authorization;
    }

    @PostMapping("/api/post03")
    public String post03(String name, int age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "post with parameter name is " + name + " age is " + age;
    }

    @PostMapping("/api/post04")
    public String post04(Nya nya) {
        System.out.println("nya = " + nya);
        return "post with parameter is domain " + nya;
    }

    @PostMapping("/api/json01")
    public String json01(@RequestBody Nya nya) {
        System.out.println("nya = " + nya);
        return "post with parameter is domain " + nya;
    }

    @PostMapping("/api/json02")
    @CrossOrigin("http://localhost:7070")
    public String json02(@RequestBody Nya nya) {
        System.out.println("nya = " + nya);
        return "post with parameter is domain " + nya;
    }

    @PostMapping("/api/axget")
    @CrossOrigin(value = "http://localhost:7070", allowCredentials = "true")
    public String axget(HttpSession httpSession) {
        System.out.println("进入了get方法");
        System.out.println("httpSession.getId() = " + httpSession.getId());
        System.out.println("httpSession.getAttribute(\"name\") = " + httpSession.getAttribute("name"));
        return "post with parameter is axget";
    }


    @PostMapping("/api/axset")
    @CrossOrigin(value = "http://localhost:7070", allowCredentials = "true")
    public String axset(HttpSession httpSession) {
        System.out.println("进入了set方法");
        System.out.println("httpSession.getId() = " + httpSession.getId());
        httpSession.setAttribute("name", "猫羽雫");
        return "post with parameter is axset";
    }
}
