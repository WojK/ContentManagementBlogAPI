package com.blogApi.controllers;

import com.blogApi.model.Category;
import com.blogApi.modelRequestDTO.CreateCategoryRequest;
import com.blogApi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest request){
        Category category = categoryService.createCategory(request);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

}
