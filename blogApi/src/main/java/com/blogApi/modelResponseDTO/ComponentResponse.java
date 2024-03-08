package com.blogApi.modelResponseDTO;


import com.blogApi.model.Component;
import com.blogApi.model.ListElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ComponentResponse {

    public ComponentResponse(Component component){
        this.id = component.getId();
        this.name = component.getName();
        this.header = component.getHeader() == null ? null
                : new HeaderResponse(component.getHeader().getText(), component.getHeader().getType());
        this.paragraph = component.getParagraph() == null ? null
                : new ParagraphResponse(component.getParagraph().getText());
        this.list = component.getTextList() == null ? null : new ListResponse(component.getTextList().getType(),
                component.getTextList().getElements().stream().map(ListElement::getText).toList());
        this.image = component.getImage() == null ? null : new ImageUriResponse(component.getImage().getName(),"/image/"+component.getImage().getName());
    }

    private Integer id;
    private String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ParagraphResponse paragraph;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ListResponse list;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private HeaderResponse header;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ImageUriResponse image;

}
