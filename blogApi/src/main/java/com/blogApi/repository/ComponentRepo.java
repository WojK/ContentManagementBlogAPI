package com.blogApi.repository;

import com.blogApi.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ComponentRepo extends JpaRepository<Component, Integer> {

    @Query("SELECT MAX(c.orderInPost)  FROM Component c WHERE c.post.id = :postId")
    public Integer getLastIndexInComponentsOrder(@Param("postId") Integer postId);
}
