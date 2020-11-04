package com.dwbfrank.blog.dao;

import com.dwbfrank.blog.model.domain.Login;

public interface UserDao {
    Login getUserByUsername(String username);
}
