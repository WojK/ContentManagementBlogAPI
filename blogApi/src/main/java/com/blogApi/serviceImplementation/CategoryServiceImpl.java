package com.blogApi.serviceImplementation;

import com.blogApi.model.Category;
import com.blogApi.model.User;
import com.blogApi.modelRequestDTO.CreateCategoryRequest;
import com.blogApi.modelRequestDTO.UpdateCategoryRequest;
import com.blogApi.repository.CategoryRepo;
import com.blogApi.repository.UserRepo;
import com.blogApi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final UserRepo userRepo;

    @Override
    public Category getCategory(Integer id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Category> getUserCategories(String userEmail) {
        User user = userRepo.findByEmail(userEmail).orElseThrow();
        return categoryRepo.findAllByUser(user);
    }

    @Override
    public Category createCategory(CreateCategoryRequest categoryRequest, String userEmail) {
        User user = userRepo.findByEmail(userEmail).orElseThrow();
        Category c = Category.builder().name(categoryRequest.getName()).user(user).build();
        return categoryRepo.save(c);
    }

    @Override
    public void updateCategory(UpdateCategoryRequest request, String userEmail) throws BadRequestException {
        Category category = categoryRepo.findById(request.getId()).orElseThrow();
        if(!category.getUser().getEmail().equals(userEmail)) throw new BadRequestException();

        category.setName(request.getName());
        categoryRepo.save(category);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        categoryRepo.deleteById(categoryId);
    }
}
