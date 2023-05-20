package com.study.elementadmin.background.mapper;

import com.study.elementadmin.background.dto.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select count(*) from user where username=#{username} and password=#{password}")
    boolean login(@Param("username") String username, @Param("password") String password);

    @Select("select * from user where username=#{username}")
    User info(String username);

    @Select("""
            select r.name from role r inner join user_role ur on r.id=ur.role_id
                where ur.user_id in (
                    select user_id from user_role ur inner join user u on ur.user_id=u.id
                        where u.username=#{username}
                )
            """)
    String[] roles(String username);

    @Select("select `key` from user where username=#{username}")
    String getKey(String username);

    @Update("update user set `key`=#{key} where username=#{username}")
    void updateKey(@Param("username") String username, @Param("key") String key);

    @Insert("""
            insert into user(username,name,avatar,introduction,`key`) 
            values(#{username},#{name},#{avatar},#{introduction},#{key}) 
            on duplicate key update name=#{name},avatar=#{avatar},`key`=#{key}""")
    void insert(@Param("username") String username, @Param("name") String name,
                @Param("avatar") String avatar,
                @Param("introduction") String introduction,
                @Param("key") String key);
}
