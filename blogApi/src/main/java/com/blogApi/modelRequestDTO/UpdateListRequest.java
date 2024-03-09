package com.blogApi.modelRequestDTO;

import com.blogApi.model.ListType;
import lombok.Getter;

import java.util.List;

@Getter
public class UpdateListRequest {

    Integer listId;
    List<String> listElements;
    ListType type;
}
