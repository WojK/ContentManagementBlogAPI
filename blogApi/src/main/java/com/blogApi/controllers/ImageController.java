package com.blogApi.controllers;

import com.blogApi.config.JwtService;
import com.blogApi.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;
    private final JwtService jwtService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("postId") Integer postId,
                                         @RequestParam(value = "image") MultipartFile image,
                                         @RequestHeader("Authorization") String authHeader) throws IOException {
        String userEmail = jwtService.extractUsername(authHeader.substring(7));
        imageService.addImageToPost(image, postId, userEmail);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
