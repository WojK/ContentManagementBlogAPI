package com.blogApi.serviceImplementation;

import com.blogApi.model.Component;
import com.blogApi.model.Paragraph;
import com.blogApi.model.Post;
import com.blogApi.modelRequestDTO.AddParagraphRequest;
import com.blogApi.repository.ComponentRepository;
import com.blogApi.repository.ParagraphRepo;
import com.blogApi.repository.PostRepo;
import com.blogApi.service.ParagraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParagraphServiceImpl implements ParagraphService {

    private final ParagraphRepo paragraphRepository;
    private final PostRepo postRepository;
    private final ComponentRepository componentRepository;

    @Override
    public boolean addParagraphToPost(AddParagraphRequest request, String userEmail) {
        Optional<Post> postEntity = postRepository.findById(request.getPostId());

        if(postEntity.isEmpty()) return false;

        Post post = postEntity.get();
        if(!post.getUser().getEmail().equals(userEmail)) return false;

        Paragraph paragraph = Paragraph.builder().text(request.getText()).build();
        Integer lastIndexInComponentsOrder = componentRepository.getLastIndexInComponentsOrder(request.getPostId());

        if(lastIndexInComponentsOrder == null) lastIndexInComponentsOrder = 0;

        Component component = Component.builder().orderInPost(lastIndexInComponentsOrder + 1).name("paragraph").post(post).build();
        componentRepository.save(component);
        paragraphRepository.save(paragraph);

        return true;
    }
}
