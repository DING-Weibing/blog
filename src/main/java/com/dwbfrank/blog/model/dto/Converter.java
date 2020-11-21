package com.dwbfrank.blog.model.dto;

import com.dwbfrank.blog.model.dto.auth.AuthData;
import com.dwbfrank.blog.model.entity.Login;

public class Converter {
    public static AuthData Login2AuthData(Login login) {
        AuthData data = new AuthData();
        data.setId(login.getId());
        data.setUsername(login.getAccount());
        data.setAvatar("https://blog-server.hunger-valley.com/avatar/69.jpg");
        data.setUpdatedAt(login.getUpdatedAt());
        data.setCreatedAt(login.getCreatedAt());
        return data;
    }
}
