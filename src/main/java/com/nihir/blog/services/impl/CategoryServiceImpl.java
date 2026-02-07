package com.nihir.blog.services.impl;

import com.nihir.blog.domain.entities.Category;
import com.nihir.blog.repos.CategoryRepository;
import com.nihir.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public List<Category> listCategories() {
return categoryRepository.findAllWithPostCount();
}

    @Override
    @Transactional
    public Category createCategory(Category category) {
        // Check if category with same name already exists
        if (categoryRepository.existsByNameIgnoreCase(category.getName())) {
            throw new IllegalArgumentException("Category already exists with name: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            if (!category.get().getPosts().isEmpty())
                throw new IllegalStateException("Category has associated posts and cannot be deleted.");
        }
        categoryRepository.deleteById(id);
    }
}
