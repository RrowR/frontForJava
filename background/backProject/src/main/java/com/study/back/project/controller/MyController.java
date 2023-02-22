package com.study.back.project.controller;

import com.study.back.project.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/toBean")
    public String toBean(User user) {  // RequestBoby需要前端传json
        System.out.println("user = " + user);
        return "成功";
    }
}
