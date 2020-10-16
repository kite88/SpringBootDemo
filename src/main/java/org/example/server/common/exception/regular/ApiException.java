package org.example.server.common.exception.regular;

import org.example.server.common.util.ApiUtil;

public class ApiException extends BaseException {

    public ApiException(String msg){
        super(msg, ApiUtil.FAIL_CODE);
    }

    public ApiException(String msg, Integer code) {
        super(msg, code);
    }
}
