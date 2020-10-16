package org.example.server.common.exception.regular;

import org.example.server.common.util.ApiUtil;

public class ApiNormalException extends ApiException {

    public ApiNormalException(String msg){
        super(msg, ApiUtil.FAIL_CODE);
    }

    public ApiNormalException(String msg, Integer code) {
        super(msg, code);
    }
}
