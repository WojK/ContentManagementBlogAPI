package com.blogApi.service;

import com.blogApi.modelRequestDTO.AddTextListRequest;
import com.blogApi.modelRequestDTO.UpdateListRequest;

public interface TextListService {
    boolean addTextListToPost(AddTextListRequest request, String userEmail);
    void updateList(UpdateListRequest request);
    boolean deleteList(Integer componentId);
}
