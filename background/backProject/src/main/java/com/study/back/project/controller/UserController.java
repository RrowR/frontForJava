package com.study.back.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.back.project.bean.Student;
import com.study.back.project.dto.R;
import com.study.back.project.dto.StudentQueryDto;
import com.study.back.project.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/api/student01/q")
    public R q(int page, int pageSize) {
        System.out.println("into q");
        List<Student> studentList = studentMapper.selectPage((page - 1) * pageSize, pageSize);
        return R.ok(studentList);
    }

    @GetMapping("/api/student01/q2")
    public R q2(int page, int pageSize,String sex,String age,String name) {
        System.out.println("into q2");
        List<Student> studentList = studentMapper.selectForm((page - 1) * pageSize, pageSize,sex,age,name);
        return R.ok(studentList);
    }

    @GetMapping("/api/student02")
    public R student02(StudentQueryDto queryDto) {
        return R.ok(studentMapper.selectById(queryDto.age()));
    }

    @PostMapping("/api/student01post")
    public R student01post() {
        System.out.println("into all");
        return R.ok(studentMapper.selectList(null));
    }
}
