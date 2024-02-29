package com.blogApi.model;

import jakarta.persistence.*;

@Entity
@Table(name="paragraphs")
public class Paragraph {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String text;

}
