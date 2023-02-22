package com.study.back.project.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: Rrow
 * @date: 2023/2/22 20:04
 * Description:
 */
@Data
public class User {
    private String username;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private int id;
}
