package com.dwbfrank.blog.service;

import com.dwbfrank.blog.model.dto.auth.BasicLogin;
import com.dwbfrank.blog.model.dto.auth.UserResultDTO;
import com.dwbfrank.blog.model.entity.Login;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {
    UserResultDTO register(String username, String password);

    UserResultDTO login(BasicLogin basicLogin);

    UserDetails loadUserByUsername(String username);

    void logout();

    Login getUser(String username);
}
