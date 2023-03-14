package com.study.back.project.controller;

import com.study.back.project.bean.Student;
import com.study.back.project.bean.User;
import com.study.back.project.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @CrossOrigin("http://localhost:7070")
    @GetMapping("/getStudent")
    public Object getStudent(){
        List<Student> students = studentMapper.selectList(null);
        return students;
    }
}
