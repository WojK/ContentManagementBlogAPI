package com.blogApi.modelRequestDTO;

import com.blogApi.model.HeaderType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddParagraphRequest extends AddComponentRequest {
    private String text;
}
