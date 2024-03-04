package com.blogApi.serviceImplementation;

import com.blogApi.model.Component;
import com.blogApi.model.Post;
import com.blogApi.repository.ComponentRepo;
import com.blogApi.repository.PostRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.IdentifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComponentServiceImpl implements ComponentService {

    private final PostRepo postRepository;
    private final ComponentRepo componentRepository;

    @Override
    public <T extends IdentifierService,K> boolean addComponentToPost(T component,
                                                                      Integer postId,
                                                                      String userEmail,
                                                                      JpaRepository<T, K> repository,
                                                                      String componentName
    ){
        Optional<Post> postEntity = postRepository.findById(postId);

        if(postEntity.isEmpty()) return false;

        Post post = postEntity.get();
        if(!post.getUser().getEmail().equals(userEmail)) return false;

        Integer lastIndexInComponentsOrder = componentRepository.getLastIndexInComponentsOrder(postId);
        component = repository.save(component);

        if(lastIndexInComponentsOrder == null) lastIndexInComponentsOrder = 0;

        Component c = Component.builder().orderInPost(lastIndexInComponentsOrder + 1).name(componentName).
                post(post).componentId(component.getId()).build();
        componentRepository.save(c);

        return true;
    }
}
