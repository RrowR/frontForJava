package com.study.elementadmin.background.controller;

import com.study.elementadmin.background.dto.R;
import com.study.elementadmin.background.dto.User;
import com.study.elementadmin.background.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/user/login")
    public R login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest.username(), loginRequest.password());
        return R.ok(Map.of("token", token));
    }

    record LoginRequest(String username, String password){}

    @GetMapping("/api/user/info")
    public R info(String token) {
        User user = userService.info(token);
        return R.ok(user);
    }

    @PostMapping("/api/user/logout")
    public R logout(@RequestHeader("Authorization") String token) {
        userService.logout(token);
        return R.ok("success");
    }
}
