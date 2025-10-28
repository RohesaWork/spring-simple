package com.example.crud.article.service;

import java.util.List;
import com.example.crud.article.entity.Article;

public interface ArticleService {
    Article createArticle(Article article);
    Article getArticleById(Long id);
    List<Article> getAllArticles();
    Article updateArticle(Long id, Article article);
    void deleteArticle(Long id);
}