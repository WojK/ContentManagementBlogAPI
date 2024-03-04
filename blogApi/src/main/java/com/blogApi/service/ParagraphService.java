package com.blogApi.service;

import com.blogApi.modelRequestDTO.AddParagraphRequest;
import com.blogApi.modelRequestDTO.UpdateParagraphRequest;

public interface ParagraphService {
    boolean addParagraphToPost(AddParagraphRequest request, String userEmail);
    boolean updateParagraph(UpdateParagraphRequest request);

}
