package com.blogApi.model;

import jakarta.persistence.*;

@Entity
@Table(name="headers")
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String text;
}
