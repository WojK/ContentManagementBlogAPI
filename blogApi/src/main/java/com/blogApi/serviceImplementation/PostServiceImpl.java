package com.blogApi.serviceImplementation;

import com.blogApi.model.Category;
import com.blogApi.model.Post;
import com.blogApi.model.User;
import com.blogApi.modelRequestDTO.CreatePostRequest;
import com.blogApi.repository.CategoryRepo;
import com.blogApi.repository.PostRepo;
import com.blogApi.repository.UserRepo;
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
    private final UserRepo userRepo;
    @Override
    public Post createPost(CreatePostRequest postRequest, String userEmail) {
        User user = userRepo.findByEmail(userEmail).orElseThrow();
        List<Category> categories = categoryRepository.findAllById(postRequest.getCategoryIds());
        Post post = Post.builder().title(postRequest.getTitle()).date(LocalDate.now()).categories(categories).user(user).build();
        return postRepository.save(post);
    }

    @Override
    public List<Post> getPosts(String userEmail){
        User user = userRepo.findByEmail(userEmail).orElseThrow();
        return postRepository.findByUser(user);
    }

    @Override
    public Post getPost(Integer id) {
        return postRepository.findById(id).orElseThrow();
    }

}
