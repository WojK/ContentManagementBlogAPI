package com.blogApi.serviceImplementation;

import com.blogApi.model.Paragraph;
import com.blogApi.modelRequestDTO.AddParagraphRequest;
import com.blogApi.repository.ParagraphRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.ParagraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParagraphServiceImpl implements ParagraphService {

    private final ParagraphRepo paragraphRepository;
    private final ComponentService componentService;

    @Override
    public boolean addParagraphToPost(AddParagraphRequest request, String userEmail) {
        Paragraph paragraph = Paragraph.builder().text(request.getText()).build();
        return componentService.addComponentToPost(paragraph,
                request.getPostId(), userEmail, paragraphRepository, "paragraph");
    }
}
