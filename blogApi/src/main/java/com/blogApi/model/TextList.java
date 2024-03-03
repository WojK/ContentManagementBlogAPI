package com.blogApi.model;

import com.blogApi.service.IdentifierService;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="lists")
@Data
public class TextList implements IdentifierService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ListType type;

    @OneToMany(mappedBy = "list")
    private List<ListElement> elements;
}

enum ListType {
    Ordered, Unordered
}