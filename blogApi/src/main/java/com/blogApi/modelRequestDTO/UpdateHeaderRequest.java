package com.blogApi.modelRequestDTO;

import com.blogApi.model.HeaderType;
import lombok.Data;

@Data
public class UpdateHeaderRequest {
    private Integer id;
    private String text;
    private HeaderType type;
}
