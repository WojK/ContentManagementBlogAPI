package com.blogApi.repository;

import com.blogApi.model.ListElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListElementRepo extends JpaRepository<ListElement, Integer> {
}
