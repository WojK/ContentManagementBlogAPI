package com.blogApi.serviceImplementation;

import com.blogApi.model.Component;
import com.blogApi.model.Paragraph;
import com.blogApi.modelRequestDTO.AddParagraphRequest;
import com.blogApi.modelRequestDTO.UpdateParagraphRequest;
import com.blogApi.repository.ComponentRepo;
import com.blogApi.repository.ParagraphRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.ParagraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParagraphServiceImpl implements ParagraphService {

    private final ParagraphRepo paragraphRepository;
    private final ComponentRepo componentRepo;
    private final ComponentService componentService;

    @Override
    public boolean addParagraphToPost(AddParagraphRequest request, String userEmail) {
        Paragraph paragraph = Paragraph.builder().text(request.getText()).build();
        return componentService.addComponentToPost(paragraph,
                request.getPostId(), userEmail, paragraphRepository, "paragraph");
    }

    @Override
    public boolean updateParagraph(UpdateParagraphRequest request) {
        Optional<Paragraph> paragraphEntity = paragraphRepository.findById(request.getId());

        if(paragraphEntity.isEmpty()) return false;

        Paragraph paragraph = paragraphEntity.get();
        paragraph.setText(request.getText());
        paragraphRepository.save(paragraph);

        return true;
    }

    @Override
    public boolean deleteParagraph(Integer componentId) {
        Optional<Component> componentEntity = componentRepo.findById(componentId);
        if(componentEntity.isEmpty()) return false;
        Component component = componentEntity.get();

        Paragraph paragraph = paragraphRepository.findById(component.getComponentId()).orElseThrow();

        componentRepo.delete(component);
        paragraphRepository.delete(paragraph);
        return true;
    }
}
