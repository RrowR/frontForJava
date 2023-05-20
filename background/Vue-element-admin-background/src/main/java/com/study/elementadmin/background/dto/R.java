package com.study.elementadmin.background.dto;

public record R(int code, Object data, String message) {
    public static R ok(Object data) {
        return new R(20000, data, null);
    }

    public static R error(int code, String message) {
        return new R(code, null, message);
    }
}
