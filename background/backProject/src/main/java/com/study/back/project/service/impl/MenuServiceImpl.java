package com.study.back.project.service.impl;

import com.study.back.project.dto.Menu;
import com.study.back.project.mapper.MenuMapper;
import com.study.back.project.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Rrow
 * @date: 2023/5/7 16:02
 * Description:
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public List<Menu> selectList() {
        return menuMapper.selectList();
    }

    @Override
    public List<Menu> findByUserName(String username) {
        log.info(username);
        List<Menu> menuList = menuMapper.findByUser(username);
        log.info(menuList.toString());
        return menuList;
    }


}
