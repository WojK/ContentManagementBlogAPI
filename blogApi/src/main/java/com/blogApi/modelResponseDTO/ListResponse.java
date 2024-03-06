package com.blogApi.modelResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ListResponse {

    String type;
    List<String> elements;
}
