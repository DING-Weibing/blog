package com.dwbfrank.blog.dao;

import javax.inject.Inject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public interface DaoFactory {
    UserDao getUserDao();

    ArticleDao getArticleDao();

    static DaoFactory getDaoFactory(String daoFQCN, Object... constructorArgs) {
        try {
            Class<?> blogDaoFactoryClass = Class.forName(daoFQCN);
            Constructor<?> constructor = Arrays.stream(blogDaoFactoryClass.getDeclaredConstructors())
                    .filter(it -> it.isAnnotationPresent(Inject.class))
                    .findFirst().get();
            return (DaoFactory) constructor.newInstance(constructorArgs);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
