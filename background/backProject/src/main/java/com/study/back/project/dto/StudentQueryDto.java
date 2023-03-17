package com.study.back.project.dto;

public record StudentQueryDto(
        // 对于年龄 1,19    =>   [1, 19]
        String name, String sex, Integer[] age, int page, int size) {

    public int offset() {
        return (page - 1) * size;
    }

    public int limit() {
        return size;
    }
}
