package com.study.back.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.back.project.bean.Student;

/**
* @author Rrow
* @description 针对表【student】的数据库操作Mapper
* @createDate 2023-03-14 15:45:45
* @Entity generator.cpm.study.back.project.bean.Student
*/
public interface StudentMapper extends BaseMapper<Student> {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
