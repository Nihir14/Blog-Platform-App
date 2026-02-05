package com.nihir.blog.services.impl;

import com.nihir.blog.domain.entities.Category;
import com.nihir.blog.repos.CategoryRepo;
import com.nihir.blog.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepository;
    @Override
    public List<Category> listCategories() {
return categoryRepository.findAllWithPostCount();
}
}
