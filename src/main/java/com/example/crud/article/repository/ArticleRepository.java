package com.example.crud.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crud.article.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {}