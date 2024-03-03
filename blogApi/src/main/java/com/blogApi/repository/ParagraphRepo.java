package com.blogApi.repository;

import com.blogApi.model.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParagraphRepo extends JpaRepository<Paragraph, Integer> {
}
