package com.blogApi.model;

import jakarta.persistence.*;

@Entity
@Table(name="elements")
public class ListElement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private TextList list;
}
