package com.blogApi.modelRequestDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddParagraphRequest extends AddComponentRequest {
    private String text;
}
