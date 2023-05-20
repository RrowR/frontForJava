package com.study.elementadmin.background.dto;

public record StudentQueryDto(
        String name, String sex, Integer[] age,
        int page, int size) {

    public int offset() {
        return (page - 1) * size;
    }

    public int limit() {
        return size;
    }
}
