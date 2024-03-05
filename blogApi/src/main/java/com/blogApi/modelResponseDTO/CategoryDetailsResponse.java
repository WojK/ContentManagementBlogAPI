package com.blogApi.modelResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetailsResponse {
    private Integer id;
    private String name;
    List<CategoryPostResponse> posts;
}

