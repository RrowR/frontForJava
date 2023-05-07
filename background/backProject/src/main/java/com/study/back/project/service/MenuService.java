package com.study.back.project.service;

import com.study.back.project.dto.Menu;

import java.util.List;

/**
 * @author: Rrow
 * @date: 2023/5/7 16:01
 * Description:
 */
public interface MenuService {

    List<Menu> selectList();

    List<Menu> findByUserName(String username);
}
