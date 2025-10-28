package com.example.crud.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crud.article.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
