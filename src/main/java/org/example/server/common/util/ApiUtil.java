package org.example.server.common.util;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ApiUtil extends LinkedHashMap<String, Object> {
    public static final Integer SUCCESS_CODE = HttpStatus.OK.value();
    public static final Integer FAIL_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();
    public static final Integer AUTH_CODE = HttpStatus.UNAUTHORIZED.value();

    public ApiUtil(Integer code, String msg, Object data) {
        if (null == code) code = 0;
        if (null == msg) msg = "";
        if (null == data) data = new HashMap<>();
        this.put("status", code);
        this.put("message", msg);
        this.put("data", data);
    }

    public static ApiUtil normal() {
        return new ApiUtil(SUCCESS_CODE, "请求成功", null);
    }

    public static ApiUtil normal(Object data) {
        return new ApiUtil(SUCCESS_CODE, "请求成功", data);
    }

    public static ApiUtil normal(Object data, String msg) {
        return new ApiUtil(SUCCESS_CODE, msg, data);
    }

    public static ApiUtil normal(Object data, String msg, Integer code) {
        return new ApiUtil(code, msg, data);
    }

    public static ApiUtil abnormal(String msg) {
        return new ApiUtil(FAIL_CODE, msg, null);
    }
}
