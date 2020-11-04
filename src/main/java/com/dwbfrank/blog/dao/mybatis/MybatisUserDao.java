package com.dwbfrank.blog.dao.mybatis;

import com.dwbfrank.blog.dao.UserDao;
import com.dwbfrank.blog.dao.mybatis.mapper.UserMapper;
import com.dwbfrank.blog.model.domain.Login;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MybatisUserDao implements UserDao {
    private final UserMapper userMapper;

    @Inject
    public MybatisUserDao(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Login getUserByUsername(String username) {
        return userMapper.selectLoginByUsername(username);
    }
}
