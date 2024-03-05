package com.blogApi.model;

import com.blogApi.service.ComponentToPostService;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="paragraphs")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Paragraph implements ComponentToPostService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private Component component;

}
