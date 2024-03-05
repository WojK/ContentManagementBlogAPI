package com.blogApi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "components")
@Builder
@Setter
@Getter
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

    @OneToOne(mappedBy = "component", cascade = CascadeType.ALL)
    private Paragraph paragraph;

    @OneToOne(mappedBy = "component", cascade = CascadeType.ALL)
    private TextList textList;

    @OneToOne(mappedBy = "component", cascade = CascadeType.ALL)
    private Header header;
}
