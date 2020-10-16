package org.example.server.common.exception.regular;

import org.example.server.common.util.ApiUtil;

public class BaseException extends Exception {

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

    private Integer code = ApiUtil.FAIL_CODE;

    public BaseException() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
