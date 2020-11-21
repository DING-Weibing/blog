package com.dwbfrank.blog.dao.mybatis;

import com.dwbfrank.blog.dao.ArticleDao;
import com.dwbfrank.blog.dao.DaoFactory;
import com.dwbfrank.blog.dao.AuthDao;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class MybatisDaoFactory implements DaoFactory {
    private final MybatisAuthDao authDao;

    @Inject
    public MybatisDaoFactory(MybatisAuthDao authDao) {
        this.authDao = authDao;
    }

    @Override
    public AuthDao getUserDao() {
        return authDao;
    }

    @Override
    public ArticleDao getArticleDao() {
        return null;
    }
}
