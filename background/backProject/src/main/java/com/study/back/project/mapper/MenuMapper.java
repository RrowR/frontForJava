package com.study.back.project.mapper;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.back.project.dto.Menu;


/**
 * @author: Rrow
 * @date: 2023/3/30 23:00
 * Description:
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> selectList();

    List<Menu> findByUser(String username);
}
