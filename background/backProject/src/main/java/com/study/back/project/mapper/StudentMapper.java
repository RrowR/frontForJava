package com.study.back.project.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.study.back.project.bean.Student;

import java.util.List;

/**
* @author Rrow
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-03-14 15:45:45
* @Entity generator.cpm.study.back.project.bean.Student
*/
public interface StudentMapper extends BaseMapper<Student> {


    List<Student> selectPage(int page,int pageSize);


    List<Student> selectForm(int page, int pageSize, String sex, String age, String name);
}
