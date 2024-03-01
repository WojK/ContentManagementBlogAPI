package com.blogApi.service;

import com.blogApi.model.Category;
import com.blogApi.modelRequestDTO.CreateCategoryRequest;

public interface CategoryService {
    Category createCategory(CreateCategoryRequest categoryRequest);
}
