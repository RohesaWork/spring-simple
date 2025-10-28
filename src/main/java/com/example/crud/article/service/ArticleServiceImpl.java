package com.example.crud.article.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.crud.article.entity.Article;
import com.example.crud.article.entity.Category;
import com.example.crud.article.repository.ArticleRepository;
import com.example.crud.article.repository.CategoryRepository;

@Service
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Article createArticle(Article article) {
        if (article.getCategory() == null || article.getCategory().getId() == null) {
            throw new RuntimeException("Gagal: Category ID tidak boleh kosong!");
        }

        Long categoryId = article.getCategory().getId();

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Gagal: Category dengan ID " + categoryId + " tidak ditemukan!"));

        article.setCategory(category);

        return articleRepository.save(article);
    }

    @Override
    public Article getArticleById(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    @Override
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article updateArticle(Long id, Article articleDetails) {
        Article existingArticle = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Gagal: Artikel dengan ID " + id + " tidak ditemukan!"));

        existingArticle.setTitle(articleDetails.getTitle());
        existingArticle.setContent(articleDetails.getContent());

        if (articleDetails.getCategory() != null && articleDetails.getCategory().getId() != null) {

            Long newCategoryId = articleDetails.getCategory().getId();

            if (!newCategoryId.equals(existingArticle.getCategory().getId())) {

                Category newCategory = categoryRepository.findById(newCategoryId).orElseThrow(() -> new RuntimeException("Gagal: Category dengan ID " + newCategoryId + " tidak ditemukan!"));
                
                existingArticle.setCategory(newCategory);
            }
        }

        return articleRepository.save(existingArticle);
    }

    @Override
    public void deleteArticle(Long id) {
        if (!articleRepository.existsById(id)) {
            throw new RuntimeException("Gagal: Artikel dengan ID " + id + " tidak ditemukan!");
        }
        articleRepository.deleteById(id);
    }
}
