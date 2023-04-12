package com.study.back.project.controller;

import com.study.back.project.dto.Menu;
import com.study.back.project.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author: Rrow
 * @date: 2023/3/30 23:07
 * Description:
 */
@RestController
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @GetMapping("/api/menu")
    public List<Menu> getMenu(){
        System.out.println("into getMenu");
        return menuMapper.selectList();
    }

}
