package com.blogApi.controllers;

import com.blogApi.config.JwtService;
import com.blogApi.model.Component;
import com.blogApi.model.Post;
import com.blogApi.modelRequestDTO.CreatePostRequest;
import com.blogApi.modelResponseDTO.*;
import com.blogApi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
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
    private final JwtService jwtService;

    @PostMapping
    ResponseEntity<?> createPost(@RequestBody CreatePostRequest request, @RequestHeader("Authorization") String authHeader){
        String userEmail = jwtService.extractUsername(authHeader.substring(7));
        Post post = postService.createPost(request, userEmail);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deletePost(@PathVariable(name = "id") Integer id, @RequestHeader("Authorization") String authHeader)
            throws BadRequestException {
        String userEmail = jwtService.extractUsername(authHeader.substring(7));
        postService.deletePost(id, userEmail);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    ResponseEntity<List<PostResponse>> getPosts(@RequestParam(name = "user") String userEmail){
        List<Post> posts = postService.getPosts(userEmail);
        return new ResponseEntity<>(posts.stream().map(p -> mapper.map(p, PostResponse.class))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<PostDetailsResponse> getPost(@PathVariable("id") Integer postId){
        Post post = postService.getPost(postId);
        List<Component> components = post.getComponents().stream()
                .sorted((x,y) -> x.getOrderInPost() - y.getOrderInPost()).toList();
        List<ComponentResponse> componentResponse = components.stream().map(ComponentResponse::new).toList();

        PostDetailsResponse postResponse = PostDetailsResponse.builder().title(post.getTitle()).id(post.getId())
                .date(post.getDate())
                .categories(post.getCategories().stream().map(x -> new CategoryResponse(x.getId(), x.getName())).toList())
                .components(componentResponse)
                .build();
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }
}
