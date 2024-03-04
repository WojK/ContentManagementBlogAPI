package com.blogApi.serviceImplementation;

import com.blogApi.model.Header;
import com.blogApi.modelRequestDTO.AddHeaderRequest;
import com.blogApi.repository.HeaderRepo;
import com.blogApi.service.ComponentService;
import com.blogApi.service.HeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeaderServiceImpl implements HeaderService {
    private final ComponentService componentService;
    private final HeaderRepo headerRepository;

    @Override
    public boolean addHeaderToPost(AddHeaderRequest request, String userEmail) {
        Header header = Header.builder().text(request.getText()).type(request.getType()).build();
        return componentService.addComponentToPost(header,
                request.getPostId(), userEmail, headerRepository, "header");
    }
}
