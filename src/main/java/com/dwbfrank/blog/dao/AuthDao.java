package com.dwbfrank.blog.dao;

import com.dwbfrank.blog.model.domain.Login;

public interface AuthDao {
    Login getLoginByAccount(String account);

    boolean createAccount(Login login);
}
