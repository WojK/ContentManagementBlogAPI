package com.blogApi.modelResponseDTO;

import com.blogApi.model.HeaderType;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HeaderResponse {

    private String text;
    private HeaderType type;
}
