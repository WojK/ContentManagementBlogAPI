package com.blogApi.service;

import com.blogApi.modelResponseDTO.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    boolean addImageToPost(MultipartFile file, Integer postId, String userEmail) throws IOException;

    ImageResponse getImageByName(String imageName) throws IOException;
}
