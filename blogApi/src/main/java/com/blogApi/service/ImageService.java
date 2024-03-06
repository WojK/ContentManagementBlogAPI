package com.blogApi.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {

    boolean addImageToPost(MultipartFile file, Integer postId, String userEmail) throws IOException;
}
