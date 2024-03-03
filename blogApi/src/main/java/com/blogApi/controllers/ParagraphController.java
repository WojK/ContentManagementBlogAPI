package com.blogApi.controllers;

import com.blogApi.config.JwtService;
import com.blogApi.modelRequestDTO.AddParagraphRequest;
import com.blogApi.service.ParagraphService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paragraph")
@RequiredArgsConstructor
public class ParagraphController {
    private final ParagraphService paragraphService;
    private final ModelMapper mapper;
    private final JwtService jwtService;

    @PostMapping
    ResponseEntity<?> addParagraphToPost(@RequestBody AddParagraphRequest request, @RequestHeader("Authorization") String authHeader){
        String userEmail = jwtService.extractUsername(authHeader.substring(7));

        boolean isSuccess = paragraphService.addParagraphToPost(request, userEmail);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
