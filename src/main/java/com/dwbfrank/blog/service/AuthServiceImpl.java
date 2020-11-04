package com.dwbfrank.blog.service;

import com.dwbfrank.blog.dao.DaoFactory;
import com.dwbfrank.blog.model.domain.Login;
import com.dwbfrank.blog.model.dto.RegisterInfo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class AuthServiceImpl implements AuthService {
    private static final String USERNAME_VALIDATOR = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$";
    private final DaoFactory daoFactory;

    @Inject
    public AuthServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public RegisterInfo register(String username, String password) {
        RegisterInfo registerInfo = new RegisterInfo();
        if (username == null || username.isEmpty()) {
            registerInfo.setStatus("fail");
            registerInfo.setMsg("用户名不可为空");
            return registerInfo;
        }
        if (username.length() > 15) {
            registerInfo.setStatus("fail");
            registerInfo.setMsg("用户名不得超过15个字符");
            return registerInfo;
        }
        if (!username.matches(USERNAME_VALIDATOR)) {
            registerInfo.setStatus("fail");
            registerInfo.setMsg("只能是字母数字下划线中文");
            return registerInfo;
        }

        return null;
    }

    @Override
    public Login login(String username, String password) {
        return daoFactory.getUserDao().getUserByUsername(username);
    }

    @Override
    public Object auth() {
        return null;
    }

    @Override
    public Object logout() {
        return null;
    }
}
