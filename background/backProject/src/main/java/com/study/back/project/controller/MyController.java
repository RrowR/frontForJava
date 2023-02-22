package com.study.back.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Rrow
 * @date: 2023/2/22 19:48
 * Description:
 */
@RestController
public class MyController {
    @GetMapping("/toback")
    public String toback(@RequestParam("username") String username) {
        System.out.println(username);
        System.out.println(username);
        System.out.println(username);
        return "成功";
    }
}
