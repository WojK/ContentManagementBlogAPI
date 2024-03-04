package com.blogApi.modelRequestDTO;

import com.blogApi.model.ListType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class AddTextListRequest extends AddComponentRequest{
    List<String> listElements;
    ListType type;
}
