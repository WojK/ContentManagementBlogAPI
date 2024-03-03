package com.blogApi.repository;

import com.blogApi.model.TextList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextListRepo extends JpaRepository<TextList, Integer> {
}
