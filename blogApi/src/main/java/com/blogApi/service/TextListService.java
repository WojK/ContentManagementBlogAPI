package com.blogApi.service;

import com.blogApi.modelRequestDTO.AddTextListRequest;

public interface TextListService {
    boolean addTextListToPost(AddTextListRequest request, String userEmail);
}
