package com.study.back.project.controller;

import com.study.back.project.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: Rrow
 * @date: 2023/2/22 19:48
 * Description:
 */
@RestController
public class MyController {
    @GetMapping("/toback")
    public String toback(@RequestParam("username") String username,@RequestParam("password") String password) {
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
}
