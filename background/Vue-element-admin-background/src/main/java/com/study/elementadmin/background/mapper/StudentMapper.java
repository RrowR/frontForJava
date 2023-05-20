package com.study.elementadmin.background.mapper;

import com.study.elementadmin.background.dto.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> findAll();

    List<Student> findBy(
            @Param("name") String name,
            @Param("sex") String sex,
            @Param("age") Integer[] age,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    long findCount(
            @Param("name") String name,
            @Param("sex") String sex,
            @Param("age") Integer[] age
    );

    @Insert("insert into student(name,sex,age) values(#{name}, {sex}, {age})")
    void insert(Student student);

    @Update("update student set name=#{name}, sex=#{sex}, age=#{age} where id=#{id}")
    void update(Student student);

    @Delete("delete from student where id=#{id}")
    void delete(int id);

    @Select("select * from student where id=#{id}")
    Student find(int id);
}
