package com.blogApi.serviceImplementation;

import com.blogApi.model.Category;
import com.blogApi.modelRequestDTO.CreateCategoryRequest;
import com.blogApi.repository.CategoryRepo;
import com.blogApi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo repository;
    @Override
    public Category createCategory(CreateCategoryRequest categoryRequest) {
        Category c = Category.builder().name(categoryRequest.getName()).build();
        return repository.save(c);
    }
}
