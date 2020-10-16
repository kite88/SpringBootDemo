package org.example.server.common.api.impl;

import org.example.server.common.api.valid.LoginValidApiCommon;
import org.example.server.common.exception.regular.ApiNormalException;
import org.example.server.common.service.impl.TokenServiceImpl;
import org.example.server.common.util.ApiUtil;
import org.example.server.common.entity.LoginResEntity;
import org.example.server.user.model.UserModel;
import org.example.server.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping("common")
public class AuthImplApiCommon {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private TokenServiceImpl tokenService;

    @PostMapping("login")
    public ApiUtil login(@Valid @RequestBody LoginValidApiCommon loginValidApiCommon) throws ApiNormalException {
        LoginResEntity loginResEntity = new LoginResEntity();
        UserModel user = userService.login(loginValidApiCommon.getUsername(), loginValidApiCommon.getPassword());
        loginResEntity.setUser(user);
        loginResEntity.setTimestamp(new Date().getTime());
        loginResEntity.setToken(tokenService.createSign(user.getId()));
        loginResEntity.setExpire(tokenService.getExpire());
        return ApiUtil.normal(loginResEntity);
    }
}
