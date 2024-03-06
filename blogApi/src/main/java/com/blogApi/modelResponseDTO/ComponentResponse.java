package com.blogApi.modelResponseDTO;


import com.blogApi.model.Component;
import com.blogApi.model.ListElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ComponentResponse {

    public ComponentResponse(Component component){
        this.id = component.getId();
        this.name = component.getName();
        this.orderInPost = component.getOrderInPost();
        this.header = component.getHeader() == null ? null
                : new HeaderResponse(component.getHeader().getText(), component.getHeader().getType());
        this.paragraph = component.getParagraph() == null ? null
                : new ParagraphResponse(component.getParagraph().getText());
        this.list = component.getTextList() == null ? null : new ListResponse(component.getTextList().getType(),
                component.getTextList().getElements().stream().map(ListElement::getText).toList());
    }

    private Integer id;
    private Integer orderInPost;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ParagraphResponse paragraph;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ListResponse list;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HeaderResponse header;

}
