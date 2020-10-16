package org.example.server.common.exception.regular;

import org.example.server.common.util.ApiUtil;

public class ApiUnauthorizedException extends ApiNormalException {

    public ApiUnauthorizedException(){
        super("请登录", ApiUtil.AUTH_CODE);
    }

    public ApiUnauthorizedException(String msg){
        super(msg, ApiUtil.AUTH_CODE);
    }
}
