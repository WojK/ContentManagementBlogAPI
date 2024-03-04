package com.blogApi.repository;

import com.blogApi.model.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepo extends JpaRepository<Header, Integer> {
}
