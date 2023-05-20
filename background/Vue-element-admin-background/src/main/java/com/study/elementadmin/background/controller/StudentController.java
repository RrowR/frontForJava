package com.study.elementadmin.background.controller;

import com.study.elementadmin.background.dto.R;
import com.study.elementadmin.background.dto.Student;
import com.study.elementadmin.background.dto.StudentQueryDto;
import com.study.elementadmin.background.dto.StudentUpdateDto;
import com.study.elementadmin.background.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/api/students")
    public R all() {
        return R.ok(studentService.findAll());
    }

    @GetMapping("/api/students/q")
    public R q(StudentQueryDto queryDto) {
        System.out.println(Arrays.toString(queryDto.age()));
        return R.ok(
                Map.of(
                        "list", studentService.findBy(queryDto),
                        "total", studentService.findCount(queryDto)
                )
        );
    }

    @DeleteMapping("/api/students/{id}")
    public R delete(@PathVariable int id) {
        studentService.delete(id);
        return R.ok("删除成功");
    }

    @PutMapping("/api/students/{id}")
    public R update(@PathVariable int id, @RequestBody StudentUpdateDto dto) {
        Student student = studentService.find(id);
        student.setName(dto.name());
        student.setSex(dto.sex());
        student.setAge(dto.age());
        studentService.update(student);
        return R.ok("修改成功");
    }

    @PostMapping("/api/students")
    public R insert(@RequestBody StudentUpdateDto dto) {
        Student student = new Student();
        student.setName(dto.name());
        student.setSex(dto.sex());
        student.setAge(dto.age());
        studentService.update(student);
        return R.ok("修改成功");
    }
}
