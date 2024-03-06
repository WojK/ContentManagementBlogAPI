package com.blogApi.modelResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class PostDetailsResponse {
    private Integer id;
    private String title;
    private LocalDate date;
    private List<CategoryResponse> categories;
    private List<ComponentResponse> components;
}
