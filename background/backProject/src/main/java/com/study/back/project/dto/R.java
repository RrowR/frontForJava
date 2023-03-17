package com.study.back.project.dto;

public record R(int code, Object data, String message) {

    public static R ok(Object data) {
        return new R(999, data, null);
    }

    public static R ok(String dataAndMessage) {
        return new R(999, dataAndMessage, dataAndMessage);
    }

    public static R error(int code, String message) {
        return new R(code, null, message);
    }
}
