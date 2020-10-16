package org.example.server.common.exception;


import org.example.server.common.exception.regular.ApiException;
import org.example.server.common.exception.regular.ApiNormalException;
import org.example.server.common.exception.regular.ApiUnauthorizedException;
import org.example.server.common.exception.regular.BaseException;

import org.example.server.common.util.ApiUtil;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 统一处理异常
 */

@RestControllerAdvice(basePackages = "org.example.server")
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ApiUtil throwableHandler(Throwable t) {
        return ApiUtil.abnormal(t.getMessage());
    }

    @ExceptionHandler
    public ApiUtil exceptionHandler(Exception e) {
        return ApiUtil.abnormal(e.getMessage());
    }

    @ExceptionHandler
    public ApiUtil exceptionHandler(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return ApiUtil.normal(null, fieldErrors.get(0).getDefaultMessage(), ApiUtil.FAIL_CODE);
    }

    @ExceptionHandler
    public ApiUtil exceptionHandler(BaseException e) {
        if (e instanceof ApiUnauthorizedException) {
            return ApiUtil.normal(null, e.getMessage(), e.getCode());
        } else if (e instanceof ApiNormalException) {
            return ApiUtil.normal(null, e.getMessage(), e.getCode());
        } else if (e instanceof ApiException) {
            return ApiUtil.normal(null, e.getMessage(), e.getCode());
        } else {
            return ApiUtil.abnormal(e.getMessage());
        }
    }

}
