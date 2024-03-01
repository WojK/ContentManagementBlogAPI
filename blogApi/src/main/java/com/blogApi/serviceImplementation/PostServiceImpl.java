package com.blogApi.serviceImplementation;

import com.blogApi.model.Category;
import com.blogApi.model.Post;
import com.blogApi.modelRequestDTO.CreatePostRequest;
import com.blogApi.repository.CategoryRepo;
import com.blogApi.repository.PostRepo;
import com.blogApi.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepo postRepository;
    private final CategoryRepo categoryRepository;
    @Override
    public Post createPost(CreatePostRequest postRequest) {
        List<Category> categories = categoryRepository.findAllById(postRequest.getCategoryIds());
        Post post = Post.builder().title(postRequest.getTitle()).date(LocalDate.now()).categories(categories).build();
        return postRepository.save(post);
    }
}
