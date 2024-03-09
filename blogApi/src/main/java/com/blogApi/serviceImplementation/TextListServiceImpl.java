package com.blogApi.serviceImplementation;

import com.blogApi.model.Component;
import com.blogApi.model.ListElement;
import com.blogApi.model.TextList;
import com.blogApi.modelRequestDTO.AddTextListRequest;
import com.blogApi.modelRequestDTO.UpdateListRequest;
import com.blogApi.repository.ComponentRepo;
import com.blogApi.repository.ListElementRepo;
import com.blogApi.repository.TextListRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.TextListService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TextListServiceImpl implements TextListService {
    private final TextListRepo textListRepo;
    private final ListElementRepo listElementRepo;
    private final ComponentService componentService;
    private final ComponentRepo componentRepo;

    @Override
    public boolean addTextListToPost(AddTextListRequest request, String userEmail) {
        TextList list = TextList.builder().type(request.getType().name()).build();
        List<ListElement> listElements = request.getListElements()
                .stream().map(x -> ListElement.builder().text(x).build()).toList();
        list.setElements(listElements);
        return componentService.addComponentToPost(list,
                request.getPostId(), userEmail, textListRepo, "list");
    }

    @Override
    @Transactional
    public void updateList(UpdateListRequest request) {
        Component componentEntity = componentRepo.findById(request.getListId()).orElseThrow();
        Integer listId = componentEntity.getTextList().getId();
        TextList list = textListRepo.findById(listId).orElseThrow();
        list.getElements().removeAll(list.getElements());
        list.setType(request.getType().toString());
        list.getElements().addAll((request.getListElements()
                .stream().map(x -> ListElement.builder().text(x).list(list).build()).toList()));
    }

    @Override
    public boolean deleteList(Integer componentId) {
        Optional<Component> componentEntity = componentRepo.findById(componentId);
        if(componentEntity.isEmpty()) return false;
        Component component = componentEntity.get();

        componentRepo.delete(component);
        return true;
    }
}
