package com.study.back.project.controller;

import com.study.back.project.dto.R;
import com.study.back.project.dto.StudentQueryDto;
import com.study.back.project.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Rrow
 * @date: 2023/3/17 18:43
 * Description:
 */
@RestController
public class UserController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/api/student01")
    public R all() {
        System.out.println("into all");
        return R.ok(studentMapper.selectList(null));
    }

    @GetMapping("/api/student02")
    public R student02(StudentQueryDto queryDto) {
        return R.ok(studentMapper.selectById(queryDto.age()));
    }
}
