package com.blogApi.service;

import com.blogApi.modelRequestDTO.AddHeaderRequest;
import com.blogApi.modelRequestDTO.UpdateParagraphRequest;

public interface HeaderService {
    boolean addHeaderToPost(AddHeaderRequest request, String userEmail);
    boolean updateHeader(UpdateParagraphRequest request);

}
