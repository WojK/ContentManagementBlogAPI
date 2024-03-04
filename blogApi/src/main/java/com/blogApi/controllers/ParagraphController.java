package com.blogApi.controllers;

import com.blogApi.config.JwtService;
import com.blogApi.modelRequestDTO.AddParagraphRequest;
import com.blogApi.modelRequestDTO.UpdateHeaderRequest;
import com.blogApi.modelRequestDTO.UpdateParagraphRequest;
import com.blogApi.service.ComponentService;
import com.blogApi.service.ParagraphService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paragraph")
@RequiredArgsConstructor
public class ParagraphController {
    private final ParagraphService paragraphService;
    private final ComponentService componentService;
    private final JwtService jwtService;

    @PostMapping
    ResponseEntity<?> addParagraphToPost(@RequestBody AddParagraphRequest request, @RequestHeader("Authorization") String authHeader){
        String userEmail = jwtService.extractUsername(authHeader.substring(7));

        boolean isSuccess = paragraphService.addParagraphToPost(request, userEmail);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    ResponseEntity<?> updateParagraph(@RequestBody UpdateParagraphRequest request){
        boolean isSuccess = paragraphService.updateParagraph(request);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    @DeleteMapping
    ResponseEntity<?> deleteParagraph(@RequestParam  Integer componentId){
        boolean isSuccess = paragraphService.deleteParagraph(componentId);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
