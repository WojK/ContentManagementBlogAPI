package com.blogApi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name= "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(name = "post_category", joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name="category_id"))
    private List<Category> categories;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Component> components;
}
