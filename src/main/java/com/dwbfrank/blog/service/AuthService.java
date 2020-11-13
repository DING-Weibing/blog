package com.dwbfrank.blog.service;

import com.dwbfrank.blog.model.dto.RegisterResult;
import com.dwbfrank.blog.model.entity.Login;

public interface AuthService {
    RegisterResult register(String username, String password);

    Login login(String username, String password);

    Object auth();

    Object logout();
}
