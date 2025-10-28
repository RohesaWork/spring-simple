package com.example.crud.article.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.crud.article.entity.Category;
import com.example.crud.article.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }
    
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = getCategoryById(id);
        if (category != null) {
            category.setName(categoryDetails.getName());
            category.setDescription(categoryDetails.getDescription());
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
