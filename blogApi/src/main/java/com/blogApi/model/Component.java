package com.blogApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "components")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Component {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "orderInPost")
    private Integer orderInPost;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "name")
    private String name;

    @Column(name = "componentId")
    private Integer componentId;

}
