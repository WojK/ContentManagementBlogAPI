package com.blogApi.controllers;

import com.blogApi.config.JwtService;
import com.blogApi.modelRequestDTO.AddHeaderRequest;
import com.blogApi.modelRequestDTO.UpdateHeaderRequest;
import com.blogApi.service.HeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/header")
@RequiredArgsConstructor
public class HeaderController {
    private final HeaderService headerService;
    private final JwtService jwtService;

    @PostMapping
    ResponseEntity<?> addHeaderToPost(@RequestBody AddHeaderRequest request, @RequestHeader("Authorization") String authHeader){
        String userEmail = jwtService.extractUsername(authHeader.substring(7));

        boolean isSuccess = headerService.addHeaderToPost(request, userEmail);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PutMapping
    ResponseEntity<?> updateHeader(@RequestBody UpdateHeaderRequest request){
        boolean isSuccess = headerService.updateHeader(request);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping
    ResponseEntity<?> deleteParagraph(@RequestParam  Integer componentId){
        boolean isSuccess = headerService.deleteHeader(componentId);
        return isSuccess ? ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
