package com.blogApi.model;

import jakarta.persistence.*;

@Entity
@Table(name="titles")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String text;
}
