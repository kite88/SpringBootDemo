package org.example.server.common.api.valid;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class LoginValidApiCommon {
    @NotEmpty(message = "请输入用户名")
    private String username;
    @NotEmpty(message = "请输入密码")
    private String password;
}
