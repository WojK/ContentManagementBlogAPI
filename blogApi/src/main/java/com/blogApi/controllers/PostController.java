package com.blogApi.controllers;

import com.blogApi.model.Post;
import com.blogApi.modelRequestDTO.CreatePostRequest;
import com.blogApi.modelResponseDTO.PostResponse;
import com.blogApi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final ModelMapper mapper;

    @PostMapping
    ResponseEntity<?> createPost(@RequestBody CreatePostRequest request){
        Post post = postService.createPost(request);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<PostResponse>> getPosts(){
        List<Post> posts = postService.getPosts();
        return new ResponseEntity<>(posts.stream().map(p -> mapper.map(p, PostResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }
}
