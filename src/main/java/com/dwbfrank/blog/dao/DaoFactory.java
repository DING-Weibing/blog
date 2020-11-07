package com.dwbfrank.blog.dao;

public interface DaoFactory {
    AuthDao getUserDao();

    ArticleDao getArticleDao();
}
