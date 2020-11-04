package com.dwbfrank.blog.dao;

import java.lang.reflect.InvocationTargetException;

public interface DaoFactory {
    UserDao getUserDao();

    ArticleDao getArticleDao();

    static DaoFactory getDaoFactory(String daoFQCN) {
        try {
            Class<?> blogDaoFactoryClass = Class.forName(daoFQCN);
            return (DaoFactory) blogDaoFactoryClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
