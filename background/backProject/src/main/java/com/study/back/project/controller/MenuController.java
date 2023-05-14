package com.study.back.project.controller;

import com.study.back.project.dto.Menu;
import com.study.back.project.dto.R;
import com.study.back.project.mapper.MenuMapper;
import com.study.back.project.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
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

    List<Map<String, Object>> list = List.of(
            Map.of("name", "张三", "age", 18),
            Map.of("name", "李四", "age", 20),
            Map.of("name", "王五", "age", 22)
    );

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

    int i = 0;
    @GetMapping("/api/user")
    public R user() throws InterruptedException {
        // Thread.sleep(1000);
        return R.ok(list.get(i++ % 3));
    }



}
