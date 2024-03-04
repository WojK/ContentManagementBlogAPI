package com.blogApi.serviceImplementation;

import com.blogApi.model.ListElement;
import com.blogApi.model.TextList;
import com.blogApi.modelRequestDTO.AddTextListRequest;
import com.blogApi.repository.TextListRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.TextListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextListServiceImpl implements TextListService {
    private final TextListRepo textListRepo;
    private final ComponentService componentService;

    @Override
    public boolean addTextListToPost(AddTextListRequest request, String userEmail) {
        TextList list = TextList.builder().type(request.getType().name()).build();
        List<ListElement> listElements = request.getListElements()
                .stream().map(x -> ListElement.builder().text(x).list(list).build()).toList();
        list.setElements(listElements);
        return componentService.addComponentToPost(list,
                request.getPostId(), userEmail, textListRepo, "list");
    }
}
