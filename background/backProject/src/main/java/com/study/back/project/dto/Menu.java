package com.study.back.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu {

    private int id;
    private String name;
    private String icon;
    private String path;
    private int pid;
    private String component;

}
