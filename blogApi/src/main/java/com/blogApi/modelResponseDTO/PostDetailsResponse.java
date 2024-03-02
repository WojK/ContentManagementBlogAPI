package com.blogApi.modelResponseDTO;

import com.blogApi.model.Category;
import com.blogApi.model.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PostDetailsResponse {
    private Integer id;
    private String title;
    private LocalDate date;
    private List<Category> categories;
    private List<Component> components;

}
