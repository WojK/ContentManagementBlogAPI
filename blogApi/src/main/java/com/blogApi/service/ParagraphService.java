package com.blogApi.service;

import com.blogApi.modelRequestDTO.AddParagraphRequest;

public interface ParagraphService {
    boolean addParagraphToPost(AddParagraphRequest request, String userEmail);
}
