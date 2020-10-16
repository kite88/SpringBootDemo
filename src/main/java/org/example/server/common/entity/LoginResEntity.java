package org.example.server.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.server.user.model.UserModel;

@Getter
@Setter
public class LoginResEntity {
    private UserModel user;
    private String token = "";
    private long expire;
    private long timestamp;
}
