package com.blogApi.model;

import com.blogApi.service.ComponentToPostService;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "images")
public class Image implements ComponentToPostService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String type;

    private String imagePath;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private Component component;
}
