package com.dwbfrank.blog.service;

import com.dwbfrank.blog.dao.AuthDao;
import com.dwbfrank.blog.dao.DaoFactory;
import com.dwbfrank.blog.model.domain.Login;
import com.dwbfrank.blog.model.dto.RegisterInfo;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class AuthServiceImpl implements AuthService {

    private final AuthDao authDao;

    @Inject
    public AuthServiceImpl(DaoFactory daoFactory) {
        authDao = daoFactory.getUserDao();
    }

    @Override
    public RegisterInfo register(String username, String password) {
        if (username == null || username.isEmpty()) {
            return RegisterInfo.getFailureRegisterInfo("用户名不可为空");
        }
        if (username.length() > 15) {
            return RegisterInfo.getFailureRegisterInfo("用户名不得超过15个字符");
        }
        if (hasInvalidCharacter(username)) {
            return RegisterInfo.getFailureRegisterInfo("只能是字母数字下划线中文");
        }
        if (isAlreadyRegistered(username)) {
            return RegisterInfo.getFailureRegisterInfo("用户名已被注册");
        }

        Login login = new Login();
        login.setAccount(username);
        login.setPassword(password);
        if (authDao.createAccount(login)) {
            login = authDao.getLoginByAccount(login.getAccount());
            return RegisterInfo.getSuccessfulRegisterInfo(login);
        } else {
            return RegisterInfo.getFailureRegisterInfo("注册失败");
        }
    }

    private boolean hasInvalidCharacter(String username) {
        String regex = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$";
        return !username.matches(regex);
    }

    private boolean isAlreadyRegistered(String username) {
        return authDao.getLoginByAccount(username) != null;
    }

    @Override
    public Login login(String username, String password) {
        return authDao.getLoginByAccount(username);
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
