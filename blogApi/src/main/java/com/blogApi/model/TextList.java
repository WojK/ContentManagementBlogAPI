package com.blogApi.model;

import com.blogApi.service.ComponentToPostService;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="lists")
@Data
@Builder
public class TextList implements ComponentToPostService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "type")
    private String type;

    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    private List<ListElement> elements;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private Component component;
}

