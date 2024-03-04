package com.blogApi.model;

import com.blogApi.service.IdentifierService;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="headers")
@Data
@Builder
public class Header implements IdentifierService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private HeaderType type;
}

