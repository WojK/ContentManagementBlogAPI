package com.blogApi.modelResponseDTO;

import com.blogApi.model.Category;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class PostResponse {
    private Integer id;
    private String title;
    private LocalDate date;
    private List<Category> categories;
}
