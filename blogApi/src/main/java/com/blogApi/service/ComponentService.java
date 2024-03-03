package com.blogApi.service;

import com.blogApi.modelRequestDTO.AddComponentRequest;
import com.blogApi.modelRequestDTO.AddParagraphRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentService {

    <T extends IdentifierService,K> boolean addComponentToPost(T component,
                                                               Integer postId,
                                                               String userEmail,
                                                               JpaRepository<T, K> repository,
                                                               String componentName
    );
}
