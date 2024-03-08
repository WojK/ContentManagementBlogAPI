package com.blogApi.modelResponseDTO;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CategoryDetailsResponse {
    private Integer id;
    private String name;
    List<CategoryPostResponse> posts;
}

