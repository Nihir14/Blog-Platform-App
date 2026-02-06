package com.nihir.blog.services;

import com.nihir.blog.domain.entities.Category;

import java.util.List;

public interface CategoryService {
    /**
     * Lists all categories with their post counts.
     */
    List<Category> listCategories();

    Category createCategory(Category category);
}
