package com.study.back.project.controller;

import com.study.back.project.dto.Menu;
import com.study.back.project.dto.R;
import com.study.back.project.mapper.MenuMapper;
import com.study.back.project.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private MenuService menuService;

    @GetMapping("/api/menu")
    public List<Menu> getMenu(){
        System.out.println("into getMenu");
        return menuService.selectList();
    }

    @GetMapping("/api/menu/{username}")
    public R findByUserName(@PathVariable String username) {
        List<Menu> menus = menuService.findByUserName(username);
        return R.ok(menus);
    }

}
