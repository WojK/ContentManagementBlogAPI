package com.blogApi.repository;

import com.blogApi.model.Category;
import com.blogApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    List<Category> findAllByUser(User user);
}
