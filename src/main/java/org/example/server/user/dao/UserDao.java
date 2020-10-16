package org.example.server.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.server.user.model.UserModel;

@Mapper
public interface UserDao extends BaseMapper<UserModel> {
}
