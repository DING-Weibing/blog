package com.dwbfrank.blog.dao.mybatis.mapper;

import com.dwbfrank.blog.model.domain.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoginMapper {
    Login selectByAccount(String account);

    int insertLogin(Login login);
}
