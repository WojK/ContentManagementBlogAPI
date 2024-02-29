package com.blogApi.model;

import jakarta.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


}
