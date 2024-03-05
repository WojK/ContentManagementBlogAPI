package com.blogApi.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComponentService {

    <T extends ComponentToPostService,K> boolean addComponentToPost(T component,
                                                                    Integer postId,
                                                                    String userEmail,
                                                                    JpaRepository<T, K> repository,
                                                                    String componentName
    );

}
