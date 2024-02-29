package com.blogApi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="lists")
public class TextList {
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