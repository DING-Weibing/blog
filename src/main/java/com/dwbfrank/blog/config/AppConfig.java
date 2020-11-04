package com.dwbfrank.blog.config;

import com.dwbfrank.blog.dao.DaoFactory;
import com.dwbfrank.blog.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public DaoFactory getDaoFactory(UserDao userDao) {
        return DaoFactory.getDaoFactory("com.dwbfrank.blog.dao.mybatis.MybatisDaoFactory", userDao);
    }
}
