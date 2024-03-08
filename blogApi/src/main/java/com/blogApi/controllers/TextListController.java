package com.blogApi.controllers;

import com.blogApi.config.JwtService;
import com.blogApi.modelRequestDTO.AddHeaderRequest;
import com.blogApi.modelRequestDTO.AddTextListRequest;
import com.blogApi.modelRequestDTO.UpdateListRequest;
import com.blogApi.modelRequestDTO.UpdateParagraphRequest;
import com.blogApi.service.TextListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
@RequiredArgsConstructor
public class TextListController {
    private final TextListService textListService;
    private final JwtService jwtService;

    @PostMapping
    ResponseEntity<?> addListToPost(@RequestBody AddTextListRequest request, @RequestHeader("Authorization") String authHeader){
        String userEmail = jwtService.extractUsername(authHeader.substring(7));

        boolean isSuccess = textListService.addTextListToPost(request, userEmail);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    ResponseEntity<?> updateList(@RequestBody UpdateListRequest request){
//        boolean isSuccess = paragraphService.updateParagraph(request);
//        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping
    ResponseEntity<?> deleteList(@RequestParam  Integer componentId){
//        boolean isSuccess = paragraphService.deleteParagraph(componentId);
//        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
