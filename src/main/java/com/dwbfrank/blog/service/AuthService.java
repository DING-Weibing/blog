package com.dwbfrank.blog.service;

import com.dwbfrank.blog.model.domain.Login;
import com.dwbfrank.blog.model.dto.RegisterInfo;

public interface AuthService {
    RegisterInfo register(String username, String password);

    Login login(String username, String password);

    Object auth();

    Object logout();
}
