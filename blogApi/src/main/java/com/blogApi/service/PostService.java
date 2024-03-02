package com.blogApi.service;

import com.blogApi.model.Post;
import com.blogApi.modelRequestDTO.CreatePostRequest;

import java.util.List;

public interface PostService {
    Post createPost(CreatePostRequest postRequest);
    List<Post> getPosts();
}
