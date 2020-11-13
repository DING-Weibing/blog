package com.dwbfrank.blog.dao.mybatis;

import com.dwbfrank.blog.dao.AuthDao;
import com.dwbfrank.blog.dao.mybatis.mapper.LoginMapper;
import com.dwbfrank.blog.model.entity.Login;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MybatisAuthDao implements AuthDao {
    private final LoginMapper loginMapper;

    @Inject
    public MybatisAuthDao(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public Login getLoginByAccount(String account) {
        return loginMapper.selectByAccount(account);
    }

    @Override
    public boolean createAccount(Login login) {
        return loginMapper.insertLogin(login) == 1;
    }
}
