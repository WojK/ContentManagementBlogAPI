package com.blogApi.controllers;

import com.blogApi.config.JwtService;
import com.blogApi.model.Category;
import com.blogApi.model.Post;
import com.blogApi.modelRequestDTO.CreateCategoryRequest;
import com.blogApi.modelRequestDTO.UpdateCategoryRequest;
import com.blogApi.modelResponseDTO.CategoryDetailsResponse;
import com.blogApi.modelResponseDTO.CategoryPostResponse;
import com.blogApi.modelResponseDTO.CategoryResponse;
import com.blogApi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapper mapper;
    private final JwtService jwtService;


    @GetMapping
    ResponseEntity<?> getCategories(@RequestParam(name = "user") String userEmail){
        List<Category> categories = categoryService.getUserCategories(userEmail);
        List<CategoryResponse> response = categories.stream()
                .map(x -> new CategoryResponse(x.getId(), x.getName())).toList();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getCategory(@PathVariable("id") Integer categoryId){
        Category category = categoryService.getCategory(categoryId);
        List<Post> posts = category.getPosts();
        List<CategoryPostResponse> postResponse = posts.stream().map(x-> new CategoryPostResponse(x.getId(), x.getTitle())).toList();
        CategoryDetailsResponse response = new CategoryDetailsResponse(category.getId(), category.getName(),postResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<?> createCategory(@RequestBody CreateCategoryRequest request, @RequestHeader("Authorization") String authHeader){
        String userEmail = jwtService.extractUsername(authHeader.substring(7));
        Category category = categoryService.createCategory(request, userEmail);
        CategoryResponse response = new CategoryResponse(category.getId(), category.getName());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<?> updateCategory(@RequestBody UpdateCategoryRequest request,
                                     @RequestHeader("Authorization") String authHeader) throws BadRequestException {
        String userEmail = jwtService.extractUsername(authHeader.substring(7));
        categoryService.updateCategory(request, userEmail);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable("id") Integer categoryId){
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
