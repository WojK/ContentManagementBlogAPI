package com.blogApi.service;

import com.blogApi.model.Post;
import com.blogApi.modelRequestDTO.CreatePostRequest;

public interface PostService {
    Post createPost(CreatePostRequest postRequest);
}
