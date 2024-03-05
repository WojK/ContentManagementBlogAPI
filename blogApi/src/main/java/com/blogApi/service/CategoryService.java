package com.blogApi.service;

import
        com.blogApi.model.Category;
import com.blogApi.modelRequestDTO.CreateCategoryRequest;
import com.blogApi.modelRequestDTO.UpdateCategoryRequest;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface CategoryService {

    Category getCategory(Integer id);
    List<Category> getUserCategories(String userEmail);
    Category createCategory(CreateCategoryRequest categoryRequest, String userEmail);

    void updateCategory(UpdateCategoryRequest request, String userEmail) throws BadRequestException;

    void deleteCategory(Integer categoryId);
}
