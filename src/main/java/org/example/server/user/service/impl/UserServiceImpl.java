package org.example.server.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.server.common.exception.regular.ApiNormalException;
import org.example.server.user.dao.UserDao;
import org.example.server.user.model.UserModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Base64;

@Service
public class UserServiceImpl {

    @Resource
    private UserDao userDao;

    /**
     * 登录查询
     *
     * @param username
     * @param password
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public UserModel login(String username, String password) throws ApiNormalException {
        QueryWrapper userModelQueryWrapper = new QueryWrapper<UserModel>();
        userModelQueryWrapper.eq("username", username);
        userModelQueryWrapper.eq("password", this.encodePassword(password));
        userModelQueryWrapper.last("limit 1");
        UserModel userModel = userDao.selectOne(userModelQueryWrapper);
        if (userModel == null) {
            throw new ApiNormalException("用户名或密码错误");
        }
        return userModel;
    }

    public String encodePassword(String password) {
        String str = DigestUtils.md5DigestAsHex(password.getBytes());
        return Base64.getEncoder().encodeToString(str.getBytes());
    }

}
