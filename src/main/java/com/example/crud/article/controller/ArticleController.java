package com.example.crud.article.controller;

import org.springframework.web.bind.annotation.*;
import com.example.crud.article.entity.Article;
import com.example.crud.article.service.ArticleService;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article articleDetails) {
        return articleService.updateArticle(id, articleDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "Article dengan ID " + id + " berhasil dihapus.";
    }
}