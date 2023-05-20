package com.study.elementadmin.background.controller;

import com.study.elementadmin.background.service.Exception401;
import com.study.elementadmin.background.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

public class LoginInterceptor implements HandlerInterceptor {

    @Value("${interceptor.mode}")
    private final InterceptorMode interceptorMode = InterceptorMode.NONE;

    @Value("${interceptor.pass}")
    private String[] interceptorPass;

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println(request.getRequestURI() + " [" + request.getMethod() + "]");
        if ("OPTIONS".equals(request.getMethod()) ||
                Stream.of(interceptorPass).anyMatch(p -> p.equals(request.getRequestURI()))) {
            return true;
        }
        switch (interceptorMode) {
            case JWT -> {
                String token = request.getHeader("Authorization");
                if (token == null) {
                    token = request.getParameter("token");
                    if (token == null) {
                        throw new Exception401("未携带 token");
                    }
                }
                userService.verify(token);
            }
            case SESSION -> {
                Object user = request.getSession().getAttribute("user");
                if (user == null) {
                    throw new Exception401("校验 session 失败");
                }
            }
            case NONE -> {
            }
        }
        return true;
    }

    enum InterceptorMode {
        NONE, JWT, SESSION;
    }
}
