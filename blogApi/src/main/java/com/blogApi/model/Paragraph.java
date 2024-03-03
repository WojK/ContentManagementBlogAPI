package com.blogApi.model;

import com.blogApi.service.IdentifierService;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="paragraphs")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph implements IdentifierService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String text;

}
