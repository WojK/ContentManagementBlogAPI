package com.blogApi.model;

import com.blogApi.service.IdentifierService;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="headers")
@Data
public class Header implements IdentifierService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String text;
}
