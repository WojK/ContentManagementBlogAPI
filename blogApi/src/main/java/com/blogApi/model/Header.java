package com.blogApi.model;

import com.blogApi.service.ComponentToPostService;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="headers")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Header implements ComponentToPostService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private HeaderType type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private Component component;
}

