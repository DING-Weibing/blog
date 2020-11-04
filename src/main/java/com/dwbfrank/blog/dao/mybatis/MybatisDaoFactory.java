package com.dwbfrank.blog.dao.mybatis;

import com.dwbfrank.blog.dao.ArticleDao;
import com.dwbfrank.blog.dao.DaoFactory;
import com.dwbfrank.blog.dao.UserDao;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MybatisDaoFactory implements DaoFactory {
    private final UserDao userDao;

    @Inject
    public MybatisDaoFactory(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public ArticleDao getArticleDao() {
        return null;
    }
}
